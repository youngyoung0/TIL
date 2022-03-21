package practice.jpa

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import practice.jpa.domain.*
import practice.jpa.repository.OrganizationRepository

@Service
class MemberServiceImpl(
    private val organizationRepository: OrganizationRepository
){

    @Transactional
    fun getList(pageable: Pageable) : ResultResponse{

        var result = ResultResponse()

        organizationRepository.getList(pageable).content.map { org ->
            result.list.add(OrganizationDTO().apply {
                this.orgId = org.id
                this.orgName = org.name
                org.teams.map { t ->
                    this.teams.add(TeamDTO().apply {
                        this.teamId = t.id
                        this.teamName = t.name
                        t.members.map { m ->
                            this.members.add(MemberDTO().apply {
                                this.memId = m.id
                                this.memName = m.name
                                this.memGender = m.gender
                                this.ban = m.ban
                            })
                        }
                    })
                }
            })
        }

        return result
    }
}