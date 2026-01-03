package Creational_Design_Pattern.Builder_Pattern.Right_Code;

class House{
    //Mandatory Fields
    private final String foundation;
    private final String structure;
    private final String roof;

    //Non-mandatory Fields
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    private House(HouseBuilder houseBuilder){
        this.foundation=houseBuilder.foundation;
        this.structure=houseBuilder.structure;
        this.roof=houseBuilder.roof;
        this.hasGarage=houseBuilder.hasGarage;
        this.hasSwimmingPool=houseBuilder.hasSwimmingPool;
        this.hasGarden=houseBuilder.hasGarden;

    }

    public static class HouseBuilder{
        //Mandatory Fields
        public String foundation;
        public String structure;
        public String roof;

        //Non-mandatory Fields
        public boolean hasGarage;
        public boolean hasSwimmingPool;
        public boolean hasGarden;

        public HouseBuilder(String foundation,String structure,String roof){
            this.roof=roof;
            this.foundation=foundation;
            this.structure=structure;
        }
        public HouseBuilder hasGardenHouse(String hasGarden){
            this.hasGarden=hasGarage;
            return this;
        }
        public HouseBuilder hasSwimmingPoolHouse(boolean hasSwimmingPool){
            this.hasSwimmingPool=hasSwimmingPool;
            return this;
        }
        public HouseBuilder hasGardenHouse(boolean hasGarden){
            this.hasGarden=hasGarden;
            return this;
        }
        public House build() {
            return new House(this);  // Pass the builder (Inner) itself
        }


    }



}
class ClientCode{
    public void hasGardenHome(){
        House houseBuilder= new House.HouseBuilder("Concrete", "Wooden","wood")
                .hasGardenHouse(false)
                .build();
        System.out.println(houseBuilder);
    }
    public void hasSwimingPoolHome(){
        House houseBuilder= new House.HouseBuilder("Concrete", "Wooden","wood")
                .hasSwimmingPoolHouse(false)
                .build();
        System.out.println(houseBuilder);
    }
}

class MainClass{
    public static void main(String[] args) {
        ClientCode clientCode=new ClientCode();
        clientCode.hasGardenHome();;
        clientCode.hasSwimingPoolHome();
    }
}