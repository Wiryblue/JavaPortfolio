package Section9_Classes_Inner_Abstract.InnerClasses;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {


//        Gearbox mcLaren = new Gearbox(6);
//        mcLaren.addGear(1,5.3);
//        mcLaren.addGear(2,10.6);
//        mcLaren.addGear(3,15.9);
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));

        class ClickListener implements Button.OnClickListener{
          public ClickListener(){
              System.out.println("I've been attached");
          }
            @Override
            public void onClick(String title) {

            }

        }
        btnPrint.setOnClickListener(new ClickListener());




    }
}