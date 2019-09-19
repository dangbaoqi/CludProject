package com.airui.service.impl;

import com.airui.dao.PaperDao;
import com.airui.exception.DaoException;
import com.airui.exception.ServiceException;
import com.airui.pojo.Paper;
import com.airui.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dangbaoqi
 * @date 2019/9/16-10:07
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public int addPaper(Paper paper) throws ServiceException {
        try{
            return paperDao.addPaper(paper);
        }catch (DaoException e){
            throw new ServiceException("添加论文失败！",e);
        }
    }

    @Override
    public int deletePaperById(long id) throws ServiceException {
        try{
            return paperDao.deletePaperById(id);
        }catch (DaoException e){
            throw new ServiceException("删除论文失败！",e);
        }
    }

    @Override
    public int updatePaper(Paper paper) throws ServiceException {
        try{
            return paperDao.updatePaper(paper);
        }catch (DaoException e){
            throw new ServiceException("更新论文失败！",e);
        }
    }

    @Override
    public Paper queryById(long id) throws ServiceException {
        try{
            return paperDao.queryById(id);
        }catch (DaoException e){
            throw new ServiceException("根据id查找论文出现异常！",e);
        }
    }

    @Override
    public List<Paper> queryAllPaper() throws ServiceException {
        try{
            return paperDao.queryAllPaper();
        }catch (DaoException e){
            throw new ServiceException("列出论文列表异常！",e);
        }
    }
}
