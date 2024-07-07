package com.jumpy.tech.whatsappclone.infrastructure.secondary.entity;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.Authority;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.AuthorityBuilder;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.AuthorityName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jilt.Builder;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="authority")
@Builder
public class AuthorityEntity{
    private static final long serialVersionUID=1L;
    @NotNull
    @Size(max=50)
    @Id
    @Column(length=50)
    private String name;
    public AuthorityEntity(){}
    public AuthorityEntity(String name){
        this.name=name;
    }
public static Set<AuthorityEntity> from(Set<Authority> authorities){
 return  authorities.stream()
         .map(authority -> com.jumpy.tech.whatsappclone.infrastructure.secondary.entity.AuthorityEntityBuilder.authorityEntity()
                         .name(authority.getName().name()).build()).collect(Collectors.toSet());

}
public static Set<Authority> toDomain(Set<AuthorityEntity> authorityEntities){
        return  authorityEntities.stream()
                .map(authority -> AuthorityBuilder.authority().name(new AuthorityName(authority.name)).build())
                .collect(Collectors.toSet());
}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityEntity that = (AuthorityEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
