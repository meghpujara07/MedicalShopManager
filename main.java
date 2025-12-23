import javax.xml.transform.Source;
import java.time.*;
public class main {
     abstract static  class Product{
         double price;
       // String Productname;
        String Companyname;
        static int totinventory;
        static double totinvestment;
        static double totprofit;
     }
    abstract static class Medicine extends Product{
        int msr;
        int presentstock;
        static int medinventory;
        static double medinvestment;
        static  double medprofit;
    }

   static class Tablet extends Medicine {
        double power_in_mg;
        int tab_per_pack;
        static int tabletinventory;
        static double tabletinvestment;
        static  double tabletprofit;

        public Tablet(double bprice,String Companyname,int m,double pq,int ww) {
            this.price = bprice;
            // this.Productname=name;
            this.Companyname = Companyname;
            this.power_in_mg = pq;
            this.presentstock = 0;
            this.tab_per_pack = ww;
            this.msr = m;

        }
            public void addstock ( int qty, double power, int tpp ){
                totinventory += qty;
                presentstock += qty;
                medinventory += qty;
                medinvestment += (price) * qty;
                totinvestment += (price) * qty;
                this.power_in_mg = power;
                this.tab_per_pack = tpp;
                tabletinventory += qty;
                tabletinvestment = qty * (price);

            }
            public void sellProduct ( int qty, int sellprice){
                if (qty > presentstock) {
                    System.out.println("DO not have required qty of that medicine");
                    return;
                }
                presentstock -= qty;
                totinventory -= qty;
                medinventory -= qty;
                tabletinventory -= qty;

                if (presentstock < msr) {
                    System.out.println("Your stock is less than the minimum stock required");
                    System.out.println("You need to add atleast" + (msr - presentstock) + "products in your inventory");

                }
                medprofit += qty * (sellprice - price);
                totprofit += qty * (sellprice - price);
                tabletprofit += qty * (sellprice - price);


            }
            public int showstock() {
                return this.presentstock;

            }
        }

    class Liquid extends Medicine{
        double weightbyvol;
        double volm;
        static  int liquidinventory;
        static double liquidprofit;
        static double liquidinvestment;
        public Liquid(int msr,double buyprice,String Compname,double wbv,double v){
            this.presentstock=0;
            this.price=buyprice;
            this.Companyname=Compname;
            this.msr=msr;
            this.weightbyvol=wbv;
            this.volm=v;
        }
        public void addstock ( int qty, double buyprice, double weightbyvol, double vlm ){
            totinventory += qty;
            presentstock += qty;
            medinventory += qty;
            medinvestment += (buyprice) * qty;
            totinvestment += (buyprice) * qty;
            this.weightbyvol = weightbyvol;
            this.volm = vlm;
            liquidinventory  += qty;
            liquidinvestment = qty * (buyprice);

        }
        public void sellProduct ( int qty, int sellprice){
            if (qty > presentstock) {
                System.out.println("DO not have required qty of that medicine");
                return;
            }
            presentstock -= qty;
            totinventory -= qty;
            medinventory -= qty;
            liquidinventory -= qty;

            if (presentstock < msr) {
                System.out.println("Your stock is less than the minimum stock required");
                System.out.println("You need to add atleast" + (msr - presentstock) + "products in your inventory");

            }
            medprofit = qty * (sellprice - price);
            totprofit = qty * (sellprice - price);
            liquidprofit += qty * (sellprice - price);


        }
        public  int showstock(){
            return this.presentstock;
        }




    }

    class NonMed extends Product{
        int presentstock;
        int msr;
        static int nonmedinventory;
        static  double nonmedinvestment;
        static double nonmedprofit;
        public NonMed(double price,String Compname,int mm){
            this.msr=mm;
            this.presentstock=0;
            this.price=price;
            this.Companyname=Compname;

        }
        public  int showstock(){
            return this.presentstock;
        }
        public void addstock ( int qty, double buyprice){
            totinventory += qty;
            presentstock += qty;
            nonmedinventory += qty;
            nonmedinvestment += (buyprice) * qty;
            totinvestment += (buyprice) * qty;


        }
        public void sellProduct ( int qty, int sellprice){
            if (qty > presentstock) {
                System.out.println("DO not have required qty of that medicine");
                return;
            }
            presentstock -= qty;
            totinventory -= qty;
            nonmedinventory -= qty;


            if (presentstock < msr) {
                System.out.println("Your stock is less than the minimum stock required");
                System.out.println("You need to add atleast" + (msr - presentstock) + "products in your inventory");

            }
            nonmedprofit = qty * (sellprice - price);
            totprofit = qty * (sellprice - price);



        }







    }



    public static void main(String[] args) {
    Tablet Paracetamol=new Tablet(350,"Synergy",300,500,5);
    Paracetamol.addstock(750,300,500);
       Paracetamol.sellProduct(300,400);
        System.out.println(Paracetamol.showstock());
        System.out.println(Medicine.medprofit);

    }
}
