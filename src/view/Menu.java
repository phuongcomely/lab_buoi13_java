package view;

import entities.AdminiStaff;
import entities.Manager;
import entities.MarketingStaff;
import service.AdminiStaffService;
import service.ManagerService;
import service.MarketingStaffService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private void displayFunction(){
        System.out.println("1--Nhập nhân viên");
        System.out.println("2--Xuất ds nhân viên");
        System.out.println("3--Xóa hoặc cập nhật lại nhân viên");
        System.out.println("4--Tìm kiếm nhân viên theo lương");
        System.out.println("5--Sắp xếp theo họ tên và thu nhập");
        System.out.println("6--Xuất 5 nhân viên có thu nhập cao nhất");
    }
    private int index(Scanner scanner){
        int choice = 0;
        try{
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

        }catch (Exception e){
            e.getMessage();
        }
        return choice;
    }
    public void displayMenu(Scanner scanner){
        AdminiStaffService adminiStaffService = new AdminiStaffService();
        ArrayList<AdminiStaff> adminiStaffs = new ArrayList<>();
        MarketingStaffService marketingStaffService = new MarketingStaffService();
        ArrayList<MarketingStaff> marketingStaffs = new ArrayList<>();
        ManagerService managerService = new ManagerService();
        ArrayList<Manager> managers = new ArrayList<>();


        System.out.println("=== CHÀO MỪNG BẠN ĐẾN VỚI CÔNG TY RỒNG VIỆT ===");
        System.out.println("Lựa chọn phòng ban nhân viên:" );
        System.out.println(" 1- nhân viên hành chính");
        System.out.println("2- Nhân viên tiếp thị ");
        System.out.println("3- Trưởng phòng");
        switch (index(scanner)){
            case 1:
                System.out.println("NHÂN VIÊN HÀNH CHÍNH");
                displayFunction();
                switch (index(scanner)){
                    case 1:
                        adminiStaffService.input(adminiStaffs); break;
                    case 2:
                        adminiStaffService.output(adminiStaffs);  break;
                    case 3:
                        adminiStaffService.remove(adminiStaffs);  break;
                    case 4:
                        adminiStaffService.search(adminiStaffs);  break;
                    case 5:
                        adminiStaffService.soft(adminiStaffs);  break;
                    case 6:
                        adminiStaffService.output5Staff(adminiStaffs);  break;
                    default:
                        System.out.println("Không hợp lệ ! Nhập lại");
                        break;
                }
            case 2:
                System.out.println("NHÂN VIÊN TIẾP THỊ");
                displayFunction();
                switch (index(scanner)){
                    case 1:
                        marketingStaffService.input(marketingStaffs);  break;
                    case 2:
                        marketingStaffService.output(marketingStaffs);  break;
                    case 3:
                        marketingStaffService.remove(marketingStaffs);  break;
                    case 4:
                        marketingStaffService.search(marketingStaffs);  break;
                    case 5:
                        marketingStaffService.soft(marketingStaffs); break;
                    case 6:
                        marketingStaffService.output5Staff(marketingStaffs); break;
                    default:
                        System.out.printf("Không hợp lệ! Nhập lại");
                }
            case 3:
                System.out.println("TRƯỞNG PHÒNG");
                displayFunction();
                switch (index(scanner)){
                    case 1:
                        managerService.input(managers);  break;
                    case 2:
                        managerService.output(managers); break;
                    case 3:
                        managerService.remove(managers); break;
                    case 4:
                        managerService.search(managers); break;
                    case 5:
                        managerService.soft(managers);  break;
                    case 6:
                        managerService.output5Staff(managers); break;
                    default:
                        System.out.println("Không hợp lệ nhập lại!");
                }
            default:
                System.out.println("Lựa chọn không đúng! mời chọn lại!");
        }

    }
}
