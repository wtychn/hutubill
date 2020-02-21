package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;
import gui.panel.DetailPanel;

import java.util.Date;
import java.util.List;

public class DetailService {
    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();

    public List<Record> list() {
        return recordDao.list();
    }

    public List<Record> list(int cid) {
        return recordDao.list(cid);
    }

    public String getCategoryName(Record r) {
        return categoryDao.get(r.cid).name;
    }

    public void update(int spend, int id, int cid, String comment, Date date) {
        Record r = new Record();
        r.setSpend(spend);
        r.setId(id);
        r.setCid(cid);
        r.setComment(comment);
        r.setDate(date);
        recordDao.update(r);
    }

    public void delete(int id) {
        recordDao.delete(id);
    }
}
