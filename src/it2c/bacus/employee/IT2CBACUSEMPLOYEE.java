
package it2c.bacus.employee;

import java.util.Scanner;


public class IT2CBACUSEMPLOYEE {

    public void addEmployee(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print(" First Name: ");
        String fname = sc.next();
        System.out.print(" Last Name: ");
        String lname = sc.next();
        System.out.print("schedule id: ");
        String id = sc.next();
        System.out.print(" day of week: ");
        String week = sc.next();
         System.out.print(" start time: ");
         String starttime = sc.next();
        System.out.print(" end time: ");
        String endtime = sc.next();

        String sql = "INSERT INTO tbl_schedule (schedule_id, day_of_week, start_time, end_time) VALUES (?, ?, ?, ?)";
        conf.addRecords(sql, fname, lname,id, week, starttime, endtime);
}
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        IT2CBACUSEMPLOYEE demo = new IT2CBACUSEMPLOYEE();
        String response;
        
        
        do{
        System.out.println("1.ADD");
         System.out.println("2.VIEW");
          System.out.println("3.UPDATE");
           System.out.println("4.DELETE");
            System.out.println("5.EXIT");
            
           System.out.print("Enter Action: ");
           int action = sc.nextInt();
           
           switch(action){
            
               case 1:
                   demo.addEmployee();
                   break;
               case 2:
                   demo.viewSchedule();
                   break;
               case 3:
                   demo.updateScedule();
                   break;
           }
        
           
           System.out.println("Continue? (yes/no)");
           response = sc.nextLine();
           
        } while(response.equalsIgnoreCase("yes"));
           System.out.println("Thank you, See you soon");
        
        }
private void viewSchedule(){
    
    String eqry = "SELECT * FROM tbl_schedule";
    String[] hrds = {"ID", "FIRSTNAME", "LASTNAME", "SCHEDULE ID", "DAY OF WEEK", "START TIME", "END TIME"};
     String[] clmns = {"schedule_id", "day_of_week", "start_time", "end_time"};
     config conf = new config();
     conf.viewEMPLOYEE(eqry, hrds, clmns);
}

private void updateScedule(){
config dbConfig = new config();
        String sqlUpdate = "UPDATE  SET name = ? WHERE  = ?";
    
}
}
        

      