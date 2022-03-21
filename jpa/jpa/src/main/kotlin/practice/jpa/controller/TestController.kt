package practice.jpa.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import practice.jpa.MemberServiceImpl
import practice.jpa.domain.Member
import practice.jpa.domain.ResultResponse
import practice.jpa.domain.SearchDTO
import practice.jpa.repository.MemberRepository

@RestController
@RequestMapping("/test")
class TestController {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Autowired
    private lateinit var memberService: MemberServiceImpl

    @PostMapping("/{page}")
    fun pagingMemberAPI(@PathVariable(name = "page") page: Int,
                        @RequestBody searchDTO: SearchDTO): ResponseEntity<Page<Member>> {

        

        return ResponseEntity.status(HttpStatus.OK).body(memberRepository.pagingMember(PageRequest.of(page-1, 50)))
    }


    @GetMapping("/org")
    fun testAPI(@RequestParam(required = false, defaultValue = "1") page : Int,
                @RequestParam(required = false, defaultValue = "50") size : Int) : ResponseEntity<ResultResponse>{

        return ResponseEntity.ok(memberService.getList(PageRequest.of(page - 1, size)))
    }



}