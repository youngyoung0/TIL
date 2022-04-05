package com.querydsl.querydsl.domain.item

import com.querydsl.querydsl.domain.Category
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@DiscriminatorColumn(name="dtype")
@Getter
@Setter
class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    var id:Long?=null
    var name:String?=null
    var price: Int ?=null
    var stockQuantity: Int?=null

    @ManyToMany(mappedBy = "items")
    var  categories:List<Category> = mutableListOf()

    // stock 줄기
    fun addFStock(quantity : Int){
        this.stockQuantity = this.stockQuantity?.plus(quantity);
    }

    // stock 감소
    fun removeStock(quantity: Int){
        var restStock = this.stockQuantity?.minus(quantity)
        if (restStock != null) {
            if(restStock < 0){
                println("notEnough")
            }
        }
        this.stockQuantity = restStock
    }



}