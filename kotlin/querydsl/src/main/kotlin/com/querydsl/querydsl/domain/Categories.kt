package com.querydsl.querydsl.domain

import com.querydsl.querydsl.domain.item.Item
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name="categories")
class Categories(){
        @Id
        @GeneratedValue
        @Column(name= "category_id")
        var id:Long ?=null
        var name:String ?=null
        @ManyToMany
        @JoinTable(name ="category_item")
        var items :List<Item> ?=null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_id")
        var  parent:Categories?=null

        @OneToMany(mappedBy = "parent")
        var child:List<Categories>  = arrayListOf<Categories>()

}