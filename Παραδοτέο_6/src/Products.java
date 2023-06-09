public class Products {
        private int Pharmacy_ID;
        private int Product_id;
        private String Product_Name;
        private double Product_Price;
        private int Product_Amount;
        private String Product_category ;
        public  Products() {};
        public Products(int Pharmacy_ID, int product_id, String product_Name, double product_Price, int product_Amount,String product_category) {
                this.Pharmacy_ID = Pharmacy_ID;
                this.Product_id = product_id;
                this.Product_Name = product_Name;
                this.Product_Price = product_Price;
                this.Product_Amount = product_Amount;
                this.Product_category = product_category;
        }

        public int getPharmacy_ID() {
                return Pharmacy_ID;
        }

        public void setPharmacy_ID(int pharmacy_ID) {
                Pharmacy_ID = pharmacy_ID;
        }

        public int getProduct_id() {
                return Product_id;
        }

        public void setProduct_id(int product_id) {
                this.Product_id = product_id;
        }

        public String getProduct_Name() {
                return Product_Name;
        }

        public void setProduct_Name(String product_Name) {
                this.Product_Name = product_Name;
        }

        public double getProduct_Price() {
                return Product_Price;
        }

        public void setProduct_Price(double product_Price) {
                this.Product_Price = product_Price;
        }

        public int getProduct_Amount() {
                return Product_Amount;
        }

        public void setProduct_Amount(int product_Amount) {
                this.Product_Amount = product_Amount;
        }

        public String getProduct_category() {
                return Product_category;
        }

        public void setProduct_category(String product_category) {
                this.Product_category = product_category;
        }
}