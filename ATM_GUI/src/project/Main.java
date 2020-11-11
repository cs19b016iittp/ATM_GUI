package project;

import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);

        new MyFrame();
    }

}

class DbConnection
{
    //   This method is to establish the connection to the database

    public static  Connection connect()
    {
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:customers_info.sqlite");

        } catch(ClassNotFoundException | SQLException e){

            System.out.println(e + "");
        }
        return conn;
    }
}

class data
{
    public static int get(String s , int p , int choice)
    {
        Connection conn = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(choice == 1)
        {
            // from here , we return the balance of a particular project.customer by fetching project.data
            // from the database

            int balance = 0;

            /*try{
                String sql = "Select Cash from project.customer where AccNo = ? " ;

                ps = conn.prepareStatement(sql);
                ps.setString(2 , s);
                rs = ps.executeQuery();


                balance = rs.getInt("Cash");

            } */
            try {
                String sql = "Select Cash from customer where AccNo = " + s;
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                balance = rs.getInt("Cash");
            }
            catch(SQLException e) {
                System.out.println(e.toString());

            } finally {
                try{
                    if(rs != null)
                    rs.close();

                    conn.close();
                } catch(SQLException e){
                    System.out.println(e.toString());
                }

            }
            return balance;
        }
        else if(choice == 2)
        {
            // verifies the data entered by the customer with the database info
            /*
            int count = 0;
            int m = p;
            while(m>0)
            {
                count++;
                m = m/10;
            }
            if(count != 5 && p != 0)
            {
                return 0;
            }*/

            int Pin=0;

           /* try{
                String sql = "SELECT * from customer where AccNo = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(2 , s);
                rs = ps.executeQuery();


                 Pin = rs.getInt("Pin");

            } */
            try {
                String sql = "Select Pin from customer where AccNo = " + s ;
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                Pin = rs.getInt("Pin");

            }
            catch(SQLException e) {


                Pin = -1;
                //System.out.println(e.toString());

            } finally {
                try{
                    if(rs != null)
                    rs.close();

                    conn.close();
                } catch(SQLException e){
                    System.out.println(e.toString());
                }

            }

           if(Pin == -1)
               return 0;
           if(Pin > 0 && p==0)
               return 1;
            if(Pin == p)
                return 1;

            return 0;
        }


        return 0;

    }
    public static void change(String s , int value1 , int value2)
    {
        // here we change the account balance of a particular project.customer

        Connection conn = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int balance = get(s , 0 , 1);
        int temp = 0;
        if(value1!=0 && value2==0)
            temp = -1* value1;
        if(value1==0 && value2!=0)
            temp = 1* value2;
        balance += temp;

        try {

            String sql = "Update customer Set Cash =  " + balance  + " Where AccNo = " + s;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

           /* ps = conn.prepareStatement(sql);
            ps.setInt(4 , balance);
            ps.executeUpdate();*/

        }
        catch(SQLException e) {
            System.out.println(e.toString());

        } finally {
            try{

                conn.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }

        }
    }

    public static boolean pinChange(String s , int n)
    {
        // here, we change the pin

        int count = 0;
        int m = n;
        while(m>0)
        {
            count++;
            m = m/10;
        }
        if(count != 5)
        {
            return false;
        }

        Connection conn = DbConnection.connect();


        try {

            String sql = "Update customer Set Pin =  " + n  + " Where AccNo = " + s;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }
        catch(SQLException e) {
           // return false;
           // System.out.println(e.toString());

        } finally {
            try{

                conn.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }

        }


        return true;
    }

    // gives back whether the card is blocked or not

    static int isBlocked(String s)
    {
        int b = 0;
        Connection conn = DbConnection.connect();
        ResultSet rs = null;
        try {
            String sql = "Select Blocked from customer where AccNo = " + s ;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            b = rs.getInt("Blocked");

        }
        catch(SQLException e) {

            //System.out.println(e.toString());

        } finally {
            try{
                if(rs != null)
                    rs.close();

                conn.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }

        }

        return b;

    }

    // blocks the card

    static  void Block(String s)
    {
        Connection conn = DbConnection.connect();
        int n = 1;

        try {

            String sql = "Update customer Set Blocked =  " + n  + " Where AccNo = " + s;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }
        catch(SQLException e) {
            // return false;
            // System.out.println(e.toString());

        } finally {
            try{

                conn.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }

        }
    }
}



abstract class customer
{
   boolean validate(String s , int p)
    {
        // calls the project.data class method to verify the input by the project.customer

        int check = data.get(s , p , 2);
        //check = project.data.get(s , p , 2);

        if(check == 1)
            return true;
        else
            return false;
    }
   // abstract boolean withdraw(String s);
   // abstract boolean deposit(String s);
   int balance(String s)
   {
       // calls the project.data class to get the account balance

       int temp=0;
       temp = data.get(s , 0 , 1);
        return temp;
      // System.out.println("Your account has a balance of " + temp + " INR");
   }



}

class atm extends customer
{
    private static int totalAmount = 1050000;

    Scanner in = new Scanner(System.in);

    int total()
    {
        return totalAmount;
    }

    void totalChange(int k)
    {
        totalAmount += k;
    }

    int getBlock(String Str)
    {
        int b = data.isBlocked(Str);
        return b;
    }

    void setBlock(String Str)
    {
        data.Block(Str);
    }

    //  these are the methods used previously
    // so , I just commented them

  /*  boolean withdraw(String s)
    {
        // asks the project.customer how much money he/she wants to withdraw and if that is possible
        // we also change the project.data from the database

        int req_amount;
        System.out.println("Enter how much money, you want to withdraw");
        System.out.println("The required amount must be a multiple of 100, else you will be directed to the main screen");
        req_amount = in.nextInt();
        if(req_amount%100 != 0)
        {
            System.out.println("Please try again");
            return false;
        }
        int acc_balance=0;
        acc_balance = data.get(s , 0 , 1);

        if(req_amount <= acc_balance && req_amount<=totalAmount)
        {

            data.change(s , req_amount , 0);


            totalAmount -=  req_amount;


            return true;
        }
        if(req_amount > acc_balance)
            System.out.println("Your account balance is insufficient");
        else
            System.out.println("Atm doesn't have the required amount" + ". Sorry for the inconvinience");
        return false;
    }

   */


   /* boolean deposit(String s)
    {
        // asks the project.customer how much money he/she wants to deposit
        // we also change the project.data from the database

        int depo_amount = 0;
        System.out.println("Enter the amount, you want to deposit");
        System.out.println("The amount must be a multiple of 100, else you will be directed to the main screen");
        depo_amount = in.nextInt();
        if(depo_amount%100 != 0)
        {
            System.out.println("Please try again");
            return false;
        }
        // add this amount into the person account
        data.change(s , 0 , depo_amount);

        totalAmount += depo_amount;

        return true;
    }*/


   /* void operations(String s)
    {
        // this asks the project.customer what operation to perform and procedes further

        System.out.println("Enter 1 to check your account balance");
        System.out.println("Enter 2 to withdraw cash");
        System.out.println("Enter 3 to deposit cash");
        System.out.println("Enter 4 to change your pin");

        int count=0;

        //   gives 3 chances for the project.customer to enter the correct input

        while(count<3)
        {

            int option = in.nextInt();
            if(option == 1)
            {
                balance(s);
            }
            else if(option == 2)
            {
                boolean possible = withdraw(s);
                if(possible)
                {
                    System.out.println("Withdraw success");
                    balance(s);
                }

            }
            else if(option == 3)
            {
                boolean possible = deposit(s);
                if(possible)
                {
                    System.out.println("Deposit success");
                    balance(s);
                   // System.out.println(totalAmount);
                }

            }
            else if(option == 4)
            {
                System.out.println("Enter the new pin");
                int temp = in.nextInt();
                boolean check = data.pinChange(s , temp);
                if(check)
                    System.out.println("Pin change successful");
                else System.out.println("Pin change unSuccessful" + ", Please enter 5 digit pin next time");
                break;
            }
            else
            {
                System.out.println("Please enter valid input");
                count++;
                continue;
            }
            break;
        }
        if(count==3)
        {
            System.out.println("You took too many chances, you are now directed to the main page");

        }


    }

    */

}


