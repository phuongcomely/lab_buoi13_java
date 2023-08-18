package service;

import entities.AdminiStaff;
import entities.Staff;
import service.impl.ICountMoney;
import service.impl.IFunction;

import java.util.*;

public class AdminiStaffService implements IFunction<AdminiStaff> {

    @Override
    public void input(ArrayList<AdminiStaff> adminiStaffs) {
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
        AdminiStaff adminiStaff =  new AdminiStaff(name, salary);
       adminiStaffs.add(adminiStaff);

    }

    @Override
    public void output(ArrayList<AdminiStaff> adminiStaffs) {
        System.out.println(" ===== DANH SÁCH NHÂN VIÊN HÀNH CHÍNH  ====");
        for(AdminiStaff adminiStaff: adminiStaffs) {

            System.out.println(adminiStaff);
        }
    }

    @Override
    public void remove(ArrayList<AdminiStaff> adminiStaffs) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bạn muốn xóa hay cập nhật thông tin nhân viên 1: xóa  2: cập nhật");
            int choose =Integer.parseInt(scanner.nextLine());
            if(choose == 1){
                System.out.println("Nhập id nhân viên cần xóa");
                int id = Integer.parseInt(scanner.nextLine());
                adminiStaffs.removeIf(adminiStaff -> adminiStaff.getId() == id);
            }else if(choose ==2 ){
                System.out.println("Nhập id nhân viên cần cập nhật lại thông tin.");
                int id = Integer.parseInt(scanner.nextLine());
                for(AdminiStaff adminiStaff : adminiStaffs){
                    if(adminiStaff.getId() == id){
                        System.out.println("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.println("Nhập lương mới: ");
                        double newSalary = Double.parseDouble(scanner.nextLine());

                        adminiStaff.setName(newName);
                        adminiStaff.setSalary(newSalary);
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
    public void search(ArrayList<AdminiStaff> adminiStaffs) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<AdminiStaff> adminiStaffs1 = new ArrayList<>();
        try{
            System.out.println("Nhập lương nhân viên cần tìm kiếm: ");
            double salary = Integer.parseInt(scanner.nextLine());
            for(AdminiStaff adminiStaff: adminiStaffs){
                if(adminiStaff.getSalary() == salary){
                   adminiStaffs1.add(adminiStaff);
                    System.out.println(adminiStaffs1);
                }
            }

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu "+e.getMessage());
        }
    }

    @Override
    public void soft(ArrayList<AdminiStaff> adminiStaffs) {
        Collections.sort(adminiStaffs, new Comparator<AdminiStaff>() {
            @Override
            public int compare(AdminiStaff o1, AdminiStaff o2) {
                if(o1.getName().equals(o2.getName())){
                    return (int) (o2.income() - o1.income());
                }else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
    }

    @Override
    public ArrayList<AdminiStaff> output5Staff(ArrayList<AdminiStaff> adminiStaffs) {
        ArrayList<AdminiStaff> adminiStaffs2 = new ArrayList<>();
        Collections.sort(adminiStaffs2, new Comparator<AdminiStaff>() {
            @Override
            public int compare(AdminiStaff o1, AdminiStaff o2) {
                return (int) (o2.income() - o1.income());
            }
        });
        return (ArrayList<AdminiStaff>) adminiStaffs2.subList(0, Math.min(5, adminiStaffs2.size()));

        }
    }

