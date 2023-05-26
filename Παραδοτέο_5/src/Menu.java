package Galenus;
import java.util.Scanner;

 class Menu {
public void showMenu(){
 System.out.println("sign in || sign up");
 boolean flag= false ;
 Scanner ins = new Scanner(System.in);
 String username ;
 Eshop es = new Eshop();
 int i;

 for (i=0;i<es.userList.size();i++){
  if(username.equals(es.userList.get(i).getusername())){
   System.out.println("Welicome to the Galenus Pharmacy");}}





 //Pharmacy_User case

 while(flag == false){
  System.out.println("Welcome showname of pharrmacy user");
  System.out.println("-------------------------------");
  System.out.println("1.Search");
  System.out.println("2.add product");
  System.out.println("3.profile");
  System.out.println("4.show history order");
  System.out.println("5.exit");
  int insert;
  insert =ins.nextInt();
  switch(insert) {
   case 1:
    System.out.println("1.Search || 2.Go back");
    int x = 0;
    Scanner X = new Scanner(System.in);
    x = X.nextInt();
    boolean sinexia = true;
    while (x == 1 && sinexia == true) {
     System.out.println("Search for...: ");
     String Search;
     Scanner se = new Scanner(System.in);
     Search = se.nextLine();
     //methodos show products apo eshop
     //System.out

     /** System.out.println("you want to search another product?");
      x=X.nextInt();**/
     System.out.println("you want to search another product?");
     boolean j;
     Scanner J = new Scanner(System.in);
     j = J.nextBoolean();


    }
    if (x == 2 || sinexia == false) {
     //go back

    }
    break;

   case 2:
    System.out.println("1.add product || 2.Go back");
    int y = 0;
    Scanner Y = new Scanner(System.in);
    y = Y.nextInt();
    boolean sinexia2 = true;
    while (y == 1 && sinexia2 == true) {
     System.out.println("add product:");
     //call method of products

     System.out.println("You want to add more products?");
   //  boolean N;
     Scanner n = new Scanner(System.in);
     sinexia2 = n.nextBoolean();


    }
    if (y == 2 || sinexia2 == false) {
     //go back
    }

    break;


   case 3:
    System.out.println("1.profile|| 2.Go back");
    int z = 0;
    Scanner Z = new Scanner(System.in);
    z = Z.nextInt();
    boolean sinexia3 = true;
    //boolean Ni = false;
    while (z == 1 && sinexia3 == true) {
     //method show Pharmacy User
     System.out.println("You to exit profile?");
     Scanner ni = new Scanner(System.in);
     sinexia3 = ni.nextBoolean();
    }
    if (z == 2 || sinexia3== false){
     //Go back
    }

     break;



   case 4 :
    System.out.println("1.Order History|| 2.Go back");
    System.out.println("1.profile|| 2.Go back");
    int p = 0;
    Scanner P= new Scanner(System.in);
    p = P.nextInt();
    boolean sinexia4 = true;
    //boolean Ni = false;
    while (p == 1 && sinexia4 == true) {
     //method show Pharmacy User
     System.out.println("You want to add more products?");
     Scanner ni = new Scanner(System.in);
     sinexia4 = ni.nextBoolean();
    }
    if (p == 2 || sinexia4== false){
     //Goback

    }break;


   case 5: break;}}



//menu for the User
  while (flag == true ) {
   System.out.println("Welcome +Usename");
   System.out.println("------------------------");
   System.out.println("1.Search ");
   System.out.println("2.Favorites");
   System.out.println("3.Products category");
   System.out.println("4.Profile");
   System.out.println("5.Exit");
   int eisodos;
   Scanner eis = new Scanner(System.in);
   eisodos = eis.nextInt();



   switch(eisodos) {
    case 1:
     System.out.println("1.Search || 2.Go back");
     int x = 0;
     Scanner X = new Scanner(System.in);
     x = X.nextInt();
     boolean sinexia = true;
     while (x == 1 && sinexia == true) {
      System.out.println("Search for...: ");
      String Search;
      Scanner se = new Scanner(System.in);
      Search = se.nextLine();
      //methodos show products apo eshop
      //System.out

      /** System.out.println("you want to search another product?");
       x=X.nextInt();**/
      System.out.println("you want to search another product?");
      boolean j;
      Scanner J = new Scanner(System.in);
      j = J.nextBoolean();


     }
     if (x == 2 || sinexia == false) {
      //go back

     }
     break;


    case 2:
     System.out.println("1.Favorites || 2.Go back");
     Scanner y = new Scanner(System.in);
     int Y = 0;
     boolean backk = true;
     Y = y.nextInt();
     while (Y == 1 && backk == true) {
      //methodos add sto favorites

      System.out.println("You want to add more products to Favorites?");
      Scanner ni = new Scanner(System.in);
      backk = ni.nextBoolean();
     }
     if (Y == 2 || backk == false) {
      //Goback

     }
     break;


    case 3:
     System.out.print("1.Show Products || 2.Go back");
     Scanner eisodos2 = new Scanner(System.in);
     int eis2;
     eis2 = eisodos2.nextInt();
     boolean backk2 = true;
     if (eis2 == 1 && backk2 == true) {
      //methodos show products

     } else if (eis2 == 2) {
      //Goback

     }
     break;


    case 4:
     System.out.print("1.Profile || 2.Go back");
     Scanner eisodos3 = new Scanner(System.in);
     int eis3;
     eis3 = eisodos3.nextInt();
     if (eis3 == 1) {
      //method for show profile
     } else if (eis3 == 2) {
      //Go back
     }
     break;


    case 5:
     break;
   } } } }