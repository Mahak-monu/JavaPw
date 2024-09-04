package io.Mahak;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table  //(name = "POKEMONE_NAME")
public class ItsPokemon {
    @Id      //primary key
    @Column  //(name = "POKiname")
    private String name;
    @Column   //(nullable = false)
    private String type;
    @Column
    private int power;
  //  @Enumerated(EnumType.STRING)
    //private Color color;
//    private String color;
//public void setColor(Color color){
   //     this.color = color;
   // }
  //  public Color getColor(){
     ///   return color;
  //  }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return type;
    }
    public void setPower(int power)
    {
        this.power = power;
    }
    public int getPower()
    {
        return power;
    }
//    public void setColor(String color){
//        this.color = color;
//    }
//    public String getColor(){
//        return color;
//    }

    @Override
    public String toString()
    {
        return this.getName()+"    "+this.getType()+"   "+this.getPower();
    }

}
