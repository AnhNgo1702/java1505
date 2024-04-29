package GUI;

import BUS.nhacungcapBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Cursor;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
public class SearchInStore extends JPanel implements MouseListener { //implements MouseListener{

    private JTextField name;
    private JTextField cheapestPrice;
    private JTextField highestPrice;
    private JComboBox<String> typeShirt;
     private JComboBox<String> sortPoint;
    private JComboBox<String> typeChucvu;
     private JComboBox<String> typeTrangthai;
    private JSpinner startDate;
    private JSpinner endDate;
    private JButton reset;
    private JButton submit;
    private Font font_title;
    private String MACHUCNANG;
    private ArrayList<String> listTitle;
    private Component pageContent;

    // private String[] titleTimkiem={"Theo tên"};
    public SearchInStore(String MACHUCNANG, Component pageContent) {
        this.pageContent = pageContent;
        this.MACHUCNANG = MACHUCNANG;
        init();

    }

    public void cssBtn(JButton b) {
        b.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
        b.setPreferredSize(new Dimension(80, (int) b.getPreferredSize().getHeight()));
        b.setOpaque(true);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.addMouseListener(this);
    }

    public JPanel itemInput(String titleInput) {
        JPanel wrap = new JPanel();
        wrap.setLayout(new GridLayout(2, 1, 0, 10));

        if (!titleInput.equalsIgnoreCase("đến")) {
            font_title = new Font("Tahoma", Font.PLAIN, 14);
            JLabel title = new JLabel(titleInput + "", JLabel.CENTER);
            title.setBackground(Color.WHITE);
            title.setOpaque(true);
            title.setFont(font_title);
            //   title.setPreferredSize(new Dimension(chieurong, 28));
            wrap.add(title);
        }
        switch (titleInput) {
            case "Theo tên":
            case "Theo tên hoặc MANCC":
            case "Theo tên sản phẩm":
            case "Theo USERNAME":
            case "Theo tên hoặc MAKH":
            case "Theo tên hoặc MANV":
            case "Theo MAPN":
            case "Theo MAHD":
            case "Theo tên hoặc MALOAI":
                name = new JTextField();

                wrap.add(name);
                break;
            case "Giá thấp nhất":
                cheapestPrice = new JTextField();
                wrap.add(cheapestPrice);
                break;
            case "Giá cao nhất":
            
                highestPrice = new JTextField();
                wrap.add(highestPrice);
                break;
            case "Tình trạng":
                typeTrangthai = new JComboBox<>(new String[]{"Tất cả", "Đang hoạt động", "Đã khóa"});
                wrap.add(typeTrangthai);
                wrap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                break;
            case "Theo chức vụ":
                typeChucvu = new JComboBox<>(new String[]{"Tất cả", "...", "...", ".."});
                wrap.add(typeChucvu);
                wrap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                break;

            case "Điểm tích lũy":
                sortPoint = new JComboBox<>(new String[]{"Ngẫu nhiên", "Thấp đến cao", "Cao đến thấp"});
                wrap.add(sortPoint);
                wrap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                break;
            case "Theo loại":
                typeShirt = new JComboBox<>(new String[]{"Tất cả", "..", "..", ".."});
                wrap.add(typeShirt);
                wrap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                break;
            case "Ngày bắt đầu":
            case "Ngày tạo TK":
            case "Theo ngày nhập": {
                startDate = new JSpinner(new SpinnerDateModel());
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(startDate, "dd/MM/yyyy");
                startDate.setEditor(dateEditor);
                wrap.add(startDate);
                break;
            }
            case "Ngày kết thúc": {
                endDate = new JSpinner(new SpinnerDateModel());
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(endDate, "dd/MM/yyyy");
                endDate.setEditor(dateEditor);
                wrap.add(endDate);
                break;
            }
            case "đến":
                JLabel den = new JLabel("đến", JLabel.CENTER);
                den.setBackground(Color.WHITE);
                den.setOpaque(true);
                wrap.add(den);
                break;
        }
        wrap.setBackground(Color.WHITE);
        wrap.setOpaque(true);
        return wrap;
    }

    private JPanel btn() {
        JPanel btn = new JPanel();
        btn.setLayout(new FlowLayout(1));
        btn.setPreferredSize(new Dimension(80, 60));
        reset = new JButton("RESET");
        cssBtn(reset);
        submit = new JButton("SUBMIT");
        cssBtn(submit);
        btn.add(submit);
        btn.add(reset);
        btn.setBackground(Color.WHITE);
        btn.setOpaque(true);

        return btn;
    }

    private void init() {

        listTitle = new ArrayList<>();
        switch (MACHUCNANG) {
            
            case "NULLTK": {
                String[] list = {};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
                        case "NULLHD": {
                String[] list = {};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "PQ": {
                String[] list = {};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            //={"Theo tên","Giá thấp nhất","đến","Giá cao nhất","Theo loại",}
            case "NCC": {
                System.out.println("Nha cung cap");
                String[] list = {"Theo tên hoặc MANCC"};
                listTitle.addAll(Arrays.asList(list));
               //submit.setName(TENCHUCNANG);
                break;
            }

//            case "Tài khoản cá nhân": {
//                String[] list = {};
//                listTitle.addAll(Arrays.asList(list));
//                break;
//            }
            case "SP": {
                String[] list = {"Theo tên sản phẩm", "Theo loại"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "TK": {
                String[] list = {"Theo USERNAME", "Tình trạng"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "KH": {
                String[] list = {"Theo tên hoặc MAKH", "Điểm tích lũy"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
//            case "Giỏ hàng": {
//                String[] list = {};
//                listTitle.addAll(Arrays.asList(list));
//                break;
//            }
            case "NV": {
                String[] list = {"Theo tên hoặc MANV","Theo chức vụ"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "PN": {
                String[] list = {"Theo MAPN", "Theo ngày nhập"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "NULLThK": {
                String[] list = {"Ngày bắt đầu", "đến", "Ngày kết thúc", "Theo loại"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "HD": {
                System.out.println("LA TAI SAOOOOOOO");
                String[] list = {"Theo MAHD", "Ngày bắt đầu", "đến", "Ngày kết thúc"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "LOAI": {
                String[] list = {"Theo tên hoặc MALOAI"};
                listTitle.addAll(Arrays.asList(list));
                break;
            }
            case "SIZE": {
                String[] list = {};
                listTitle.addAll(Arrays.asList(list));
                break;
            }

        }
        if (!listTitle.isEmpty()) {
             System.out.println("heheheheheheheh");
//            setPreferredSize(new Dimension(chieurong, 117));

            JPanel jp_title = new JPanel();
            jp_title.setLayout(new BorderLayout());
            jp_title.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
            jp_title.setOpaque(true);
            JLabel jl_title = new JLabel("<html><h1 style='font-family:Tahoma;font-weight:600;font-size:16;'>Tìm kiếm</h1></html>");

            jp_title.add(jl_title, BorderLayout.WEST);

            JPanel x = new JPanel();

            font_title = new Font("Tahoma", Font.PLAIN, 14);

            x.setLayout(new FlowLayout(3, 20, 0));
            x.setBackground(Color.white);
            x.setOpaque(true);
//            x.setPreferredSize(new Dimension(chieurong, 80));
            for (String titleTimkiem1 : listTitle) {
               
                JPanel child_x = itemInput(titleTimkiem1);

                x.add(child_x);
            }

            JPanel btn = new JPanel(new BorderLayout());
            btn.add(btn(), BorderLayout.CENTER);
            x.add(btn);

            Border top = BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK);
            Border arround = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
            x.setBorder(BorderFactory.createCompoundBorder(top, arround));

            setLayout(new FlowLayout(3, 0, 0));
            jp_title.setPreferredSize(new Dimension((int) jl_title.getPreferredSize().getWidth() + 10, (int) jl_title.getPreferredSize().getHeight()));
            add(jp_title);
            x.setPreferredSize(new Dimension((int) x.getPreferredSize().getWidth(), 70));
            setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
            setOpaque(true);
            add(x);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        try {
//            JPanel btn_click = (JPanel) e.getSource();
//            String chucnang = btn_click.getName();
//            ArrayList<String> data_filter = new ArrayList<>();
//            if (!name.getText().equals("")) {
//                data_filter.add(name.getText());
//            }
//            switch (chucnang) {
//                case "Nhà cung cấp":
//                    nhacungcapBUS nccBUS = new nhacungcapBUS();
//                    nhacungcapGUI nccGUI = (nhacungcapGUI) pageContent;
//                    nccGUI.addDataInTable(nccBUS.search(data_filter));
//                    break;
//            }
//        } catch (Exception ex) {
//
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try {
            JButton menuItem = (JButton) e.getSource();
            menuItem.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            menuItem.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
            menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } catch (Exception ex) {
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        try {
            JButton menuItem = (JButton) e.getSource();
            menuItem.setForeground(Color.WHITE);
            menuItem.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
        } catch (Exception ex) {
        }

    }
}
