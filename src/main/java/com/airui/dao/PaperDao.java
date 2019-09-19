package com.airui.dao;

import com.airui.exception.DaoException;
import com.airui.pojo.Paper;
import java.util.List;

/**
 * @author dangbaoqi
 * @date 2019/9/16-10:09
 */
public interface PaperDao {
    int addPaper(Paper paper) throws DaoException;

    int deletePaperById(long id) throws DaoException;

    int updatePaper(Paper paper) throws DaoException;

    Paper queryById(long id) throws DaoException;

    List<Paper> queryAllPaper() throws DaoException;
}
