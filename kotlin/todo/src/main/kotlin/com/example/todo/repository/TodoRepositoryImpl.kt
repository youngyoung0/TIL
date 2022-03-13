package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl: TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase

    override fun save(todo: Todo): Todo? {

        return todo.index?.let{ index->
            // update
            findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updateAt = todo.updateAt
            }
        }?: kotlin.run{
            // insert
            todo.apply{
                this.index = ++todoDataBase.index
                this.createAt = LocalDateTime.now()
                this.updateAt = LocalDateTime.now()
            }.run{
                todoDataBase.todoList.add(todo)
                this
            }
        }

    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try{
            todoList.forEach{
                save(it)
            }
            true
        }catch(e: Exception){
            false
        }
    }

    override fun delete(index: Int): Boolean {
        val todo = findOne(index)

        return todo?.let{
            todoDataBase.todoList.remove(it)
            true
        }?: kotlin.run{
            false
        }
    }

    override fun findOne(index: Int): Todo? {
        return todoDataBase.todoList.filter{it.index == index}.first()
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}