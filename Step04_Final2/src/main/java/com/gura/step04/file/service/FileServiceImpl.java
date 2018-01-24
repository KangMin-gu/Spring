package com.gura.step04.file.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.file.dao.FileDao;
import com.gura.step04.file.dto.FileDto;

@Service
public class FileServiceImpl implements FileService{
	
	//의존객체
	@Autowired
	private FileDao fileDao;
	
	@Override
	public void insert(HttpServletRequest request, FileDto dto) {
		//파일을 저장할 폴더의 절대 경로를 얻어온다.
		String realPath=request.getSession()
				.getServletContext().getRealPath("/upload");
		//콘솔에 경로 출력해보기
		System.out.println(realPath);
		
		//MultipartFile 객체의 참조값 얻어오기
		//FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
		MultipartFile mFile=dto.getFile(); // 이것을 이용해서 dto 나머지 값을 구해온다. 
		//원본 파일명
		String orgFileName=mFile.getOriginalFilename();
		//파일 사이즈
		long fileSize=mFile.getSize();
		//저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		//디렉토리를 만들 파일 객체 생성
		File file=new File(filePath);
		if(!file.exists()){//디렉토리가 존재하지 않는다면
			file.mkdir();//디렉토리를 만든다.
		}
		//파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
		String saveFileName=System.currentTimeMillis()+orgFileName;
		try{
			//upload 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//추출한 3가지 정보를 dto에 넣는다. 
		//FileDto 객체에 추가 정보를 담는다.
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		
		//세션에서 작성자 정보를 얻어온다. 
		String id = (String)request.getSession().getAttribute("id");
		//FileDto 객체에 작성자 정보를 담는다. 
		dto.setWriter(id);
		
		//FileDao 객체를 이용해서 DB 에 저장하기
		fileDao.insert(dto);
		
	}

	@Override
	public ModelAndView list() {
		//Dao를 이용해서 파일 목록을 얻어와서
		List<FileDto> list = fileDao.getList();
		//ModelAndView 객체에 담아서
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		//리턴한다.
		return mView;
	}

	@Override
	public void delete(HttpServletRequest request, int num) {
		
		//삭제할 파일의 정보를 얻어온다. 
		FileDto dto = fileDao.getData(num);
		//1.파일 시스템에서 물리적인 삭제
		String path = 
				request.getServletContext().getRealPath("/upload")+
				File.separator+dto.getSaveFileName();
		try{
			new File(path).delete();
		}catch (Exception e){}
		//2. DB 에서 파일 정보 삭제 
		fileDao.delete(num);
		
	}

	@Override
	public ModelAndView getData(int num) {
		//Dao 를 이용해서 파일 정보를 얻어와서
		FileDto dto = fileDao.getData(num);
		//ModelAndView 객체에 담아서
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		//리턴한다.
		return mView;
	}

}
