package practice.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import practice.jpa.domain.Organization

@Repository
interface OrganizationRepository : JpaRepository<Organization, Long> , OrganizationRepositoryCustom {
}