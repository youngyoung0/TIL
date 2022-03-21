package practice.jpa.repository

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import practice.jpa.domain.Organization
import practice.jpa.domain.SearchDTO

interface OrganizationRepositoryCustom {
    fun getList( pageable: Pageable) : PageImpl<Organization>
}