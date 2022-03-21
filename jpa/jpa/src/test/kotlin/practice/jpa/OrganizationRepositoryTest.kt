package practice.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.test.annotation.Rollback
import practice.jpa.domain.Member
import practice.jpa.domain.Organization
import practice.jpa.repository.OrganizationRepository
import java.util.stream.IntStream

@SpringBootTest
class OrganizationRepositoryTest(
    @Autowired
    val organizationRepository: OrganizationRepository
) {

    @Test
    @Rollback(value = false)
    fun insertTest(){

        IntStream.rangeClosed(1, 100).forEach {
            var organization = Organization()
            organization.name = "organization $it"

            organizationRepository.save(organization)
        }

    }


    @Test
    fun findByIdTest(){
        val findOrg = organizationRepository.findById(1).get()

        println(findOrg.id)
        println(findOrg.name)
    }

}