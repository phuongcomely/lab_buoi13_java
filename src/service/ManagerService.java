package service;

import entities.Manager;
import entities.MarketingStaff;
import entities.Staff;
import service.impl.IFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerService  implements IFunction<Manager> {

    @Override
    public void input(ArrayList<Manager> managers) {
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

        double salaryRes=0;
        try{
            System.out.println("Nhập lương trách nhiệm của nhân viên: ");
            salaryRes = Double.parseDouble(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Lỗi "+e.getMessage());
        }
        Manager manager = new Manager(name, salary, salaryRes);
        managers.add(manager);
        System.out.println("Thêm thành công!");
    }

    @Override
    public void output(ArrayList<Manager> managers) {
        System.out.println("=== DANH SÁCH TRƯỞNG PHÒNG ===");
        for(Manager manager: managers){
            System.out.println(manager);
        }
    }

    @Override
    public void remove(ArrayList<Manager> managers) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bạn muốn xóa hay cập nhật thông tin nhân viên 1: xóa  2: cập nhật");
            int choose =Integer.parseInt(scanner.nextLine());
            if(choose == 1){
                System.out.println("Nhập id nhân viên cần xóa");
                int id = Integer.parseInt(scanner.nextLine());
                managers.removeIf(manager -> manager.getId() == id);

            }else if(choose ==2 ){
                System.out.println("Nhập id nhân viên cần cập nhật lại thông tin.");
                int id = Integer.parseInt(scanner.nextLine());
                for(Manager manager:managers){
                    if(manager.getId() == id){
                        System.out.println("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.println("Nhập lương mới: ");
                        double newSalary = Double.parseDouble(scanner.nextLine());
                        System.out.println("Cập nhật lại lương trách nhiệm: ");
                        double newSalaryRes = Double.parseDouble(scanner.nextLine());

                        manager.setName(newName);
                        manager.setSalary(newSalary);
                        manager.setSalaryResponsible(newSalaryRes);
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
    public void search(ArrayList<Manager> managers) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Manager> managers1 = new ArrayList<>();
        try{
            System.out.println("Nhập lương nhân viên cần tìm kiếm: ");
            double salary = Integer.parseInt(scanner.nextLine());
            for(Manager manager: managers){
                if(manager.getSalary() == salary){
                    managers1.add(manager);
                    System.out.println(managers1);
                }
            }

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu "+e.getMessage());
        }
    }

    @Override
    public void soft(ArrayList<Manager> managers) {
        Collections.sort(managers, new Comparator<Manager>() {
            @Override
            public int compare(Manager o1, Manager o2) {
                if (o1.getName().equals(o2.getName())) {
                    return (int) (o2.income() - o1.income());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
    });
    }

    @Override
    public ArrayList<Manager> output5Staff(ArrayList<Manager> managers) {
        ArrayList<Manager> managers2 = new ArrayList<>();
        Collections.sort(managers2, new Comparator<Manager>() {
            @Override
            public int compare(Manager o1, Manager o2) {
                return (int) (o2.income() - o1.income());
            }
        });

        return (ArrayList<Manager>) managers2.subList(0, Math.min(5, managers2.size()));

    }

}
