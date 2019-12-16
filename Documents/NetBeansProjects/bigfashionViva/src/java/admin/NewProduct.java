package admin;

import dbmodels.Catogory;
import dbmodels.Product;
import hiberate.HibernateUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class NewProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

            String path = getServletContext().getRealPath("") + "//res";

            List<FileItem> items = fileUpload.parseRequest(req);
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            Product product = new Product();
            for (FileItem item : items) {
                if (!(item.getFieldName().equals("image1") || item.getFieldName().equals("image2"))) {
                    switch (item.getFieldName()) {
                        case "name":
                            product.setName(item.getString());
                            break;
                        case "des":
                            product.setDescription(item.getString());
                            break;
                        case "category":
                            Criteria c = session.createCriteria(Catogory.class);
                            c.add(Restrictions.eq("name", item.getString()));
                            Catogory cat = (Catogory) c.uniqueResult();
                            product.setCatogoryId(cat);
                            break;
                        case "price":
                            product.setPrice(Float.parseFloat(item.getString()));
                            break;
                        case "size":
                            product.setSize(item.getString());
                            break;
                        case "qnty":
                            product.setQnt(Integer.parseInt(item.getString()));
                            break;

                    }
                } else {
                    String name = System.currentTimeMillis() + item.getName();
                    File f = new File(path + "//" + name);
                    item.write(f);

                    if (item.getFieldName().equals("image1")) {
                        product.setImage1(name);
                    } else if (item.getFieldName().equals("image2")) {
                        product.setImage2(name);
                    }
                }
            }

            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            session.close();
            resp.getWriter().print(true);

        } catch (Exception e) {
            resp.getWriter().print(false);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(getServletContext().getRealPath("") + "\\res");
    }

}
