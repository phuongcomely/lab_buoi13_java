package service;

import entities.AdminiStaff;
import entities.MarketingStaff;
import entities.Staff;
import service.impl.ICountMoney;
import service.impl.IFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MarketingStaffService implements IFunction<MarketingStaff> {


    @Override
    public void input(ArrayList<MarketingStaff> marketingStaffs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        double salary = 0;
        try{
            System.out.println("Nhập lương nhân viên: ");
            salary = Double.parseDouble(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu: "+e.getMessage());
        }
        double sales = 0;
        try{

            System.out.println("Nhập doanh số bán hàng của nhân viên: ");
            sales = Double.parseDouble(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Lỗi "+ e.getMessage());
        }

        double commissionRate = 0;
        try {
            System.out.println("Nhập tỉ lệ hoa hồng đạt được: ");
            commissionRate = Double.parseDouble(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Lỗi "+e.getMessage());
        }
        MarketingStaff marketingStaff = new MarketingStaff(name, salary, sales, commissionRate);
        marketingStaffs.add(marketingStaff);
    }

    @Override
    public void output(ArrayList<MarketingStaff> marketingStaffs) {
        System.out.println(" ===== DANH SÁCH NHÂN VIÊN TIẾP THỊ ====");
        for(MarketingStaff marketingStaff: marketingStaffs) {

            System.out.println(marketingStaff);
        }
    }

    @Override
    public void remove(ArrayList<MarketingStaff> marketingStaffs) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bạn muốn xóa hay cập nhật thông tin nhân viên 1: xóa  2: cập nhật");
            int choose =Integer.parseInt(scanner.nextLine());
            if(choose == 1){
                System.out.println("Nhập id nhân viên cần xóa");
                int id = Integer.parseInt(scanner.nextLine());
                marketingStaffs.removeIf(marketingStaff -> marketingStaff.getId() == id);

            }else if(choose ==2 ){
                System.out.println("Nhập id nhân viên cần cập nhật lại thông tin.");
                int id = Integer.parseInt(scanner.nextLine());
                for(MarketingStaff marketingStaff: marketingStaffs){
                    if(marketingStaff.getId() == id){
                        System.out.println("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.println("Nhập lương mới: ");
                        double newSalary = Double.parseDouble(scanner.nextLine());
                        System.out.println("Cập nhật lại doanh số: ");
                        double newSales = Double.parseDouble(scanner.nextLine());
                        System.out.println("Cập nhật lại hoa hồng: ");
                        double newCommissionRate = Double.parseDouble(scanner.nextLine());
                       marketingStaff.setName(newName);
                        marketingStaff.setSalary(newSalary);
                        marketingStaff.setSales(newSales);
                        marketingStaff.setCommissionRate(newCommissionRate);
                        System.out.println("Cập nhật thành công");


                    }
                }
            }else
                System.out.println("lựa chọn không phù hợp. Mời nhập lại");

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu : "+e.getMessage());
        }

    }

    @Override
    public void search(ArrayList<MarketingStaff> marketingStaffs) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MarketingStaff> marketingStaffs1 = new ArrayList<>();
        try{
            System.out.println("Nhập lương nhân viên cần tìm kiếm: ");
            double salary = Integer.parseInt(scanner.nextLine());
            for(MarketingStaff marketingStaff: marketingStaffs){
                if(marketingStaff.getSalary() == salary){
                    marketingStaffs1.add(marketingStaff);
                    System.out.println(marketingStaffs1);
                }
            }

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu "+e.getMessage());
        }
    }

    @Override
    public void soft(ArrayList<MarketingStaff> marketingStaffs) {
        Collections.sort(marketingStaffs, new Comparator<MarketingStaff>() {
            @Override
            public int compare(MarketingStaff o1, MarketingStaff o2) {
                if (o1.getName().equals(o2.getName())) {
                    return (int) (o2.income() - o1.income());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

    }

    @Override
    public ArrayList<MarketingStaff> output5Staff(ArrayList<MarketingStaff> marketingStaffs) {
        ArrayList<MarketingStaff> marketingStaffs2 = new ArrayList<>();
        Collections.sort(marketingStaffs2, new Comparator<MarketingStaff>() {
            @Override
            public int compare(MarketingStaff o1, MarketingStaff o2) {
                    return (int) (o2.income() - o1.income());
                }

        });
        return (ArrayList<MarketingStaff>) marketingStaffs2.subList(0, Math.min(5, marketingStaffs2.size()));

    }

}
