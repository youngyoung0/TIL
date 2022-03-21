package practice.jpa.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import practice.jpa.domain.Organization
import practice.jpa.domain.QOrganization
import practice.jpa.domain.SearchDTO
import javax.annotation.Resource

class OrganizationRepositoryImpl(
    @Resource(name = "jpaQueryFactory")
    val query : JPAQueryFactory
) : QuerydslRepositorySupport(Organization::class.java) , OrganizationRepositoryCustom {

    override fun getList( pageable: Pageable): PageImpl<Organization> {
        var result = query.select(QOrganization.organization)
            .from(QOrganization.organization)

        var totalCount = result.fetchCount()
        var results : MutableList<Organization> = querydsl?.applyPagination(pageable, result)?.fetch() as MutableList<Organization>
        return PageImpl(results, pageable, totalCount)
    }
}