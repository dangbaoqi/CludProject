package com.airui.service;

import com.airui.exception.ServiceException;
import com.airui.pojo.Paper;

import java.util.List;

/**
 * @author dangbaoqi
 * @date 2019/9/16-10:05
 */
public interface PaperService {
    int addPaper(Paper paper) throws ServiceException;

    int deletePaperById(long id) throws ServiceException;

    int updatePaper(Paper paper) throws ServiceException;

    Paper queryById(long id) throws ServiceException;

    List<Paper> queryAllPaper() throws ServiceException;

}
