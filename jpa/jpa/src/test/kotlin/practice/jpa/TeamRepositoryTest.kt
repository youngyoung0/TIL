package practice.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.test.annotation.Rollback
import practice.jpa.domain.Organization
import practice.jpa.domain.Team
import practice.jpa.repository.OrganizationRepository
import practice.jpa.repository.TeamRepository
import java.util.stream.IntStream

@SpringBootTest
class TeamRepositoryTest(
    @Autowired
    val teamRepository: TeamRepository,

    @Autowired
    val organizationRepository: OrganizationRepository
) {


    @Test
    @Rollback(value = false)
    fun insertTest(){

        IntStream.rangeClosed(1, 200).forEach {
            var team = Team()
            team.name = "team $it"

            if (it < 100){
                team.organization = organizationRepository.findById(1L).get()
            } else {
                team.organization = organizationRepository.findById(2L).get()
            }

            teamRepository.save(team)
        }
    }


}