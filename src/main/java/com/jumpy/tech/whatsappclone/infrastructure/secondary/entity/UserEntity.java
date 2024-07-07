package com.jumpy.tech.whatsappclone.infrastructure.secondary.entity;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.UserBuilder;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.*;
import com.jumpy.tech.whatsappclone.shared.jpa.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.jilt.Builder;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="whatsapp_user")
@Builder
public class UserEntity extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userSequenceGenerator")
    @SequenceGenerator(name = "userSequenceGenerator",sequenceName = "user_sequence",allocationSize = 1)
    private Long id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name="public_Id",updatable = false)
    @UuidGenerator
    private UUID publicId;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="email")
    private String email;
    @Column(name="last_seen ")
    private Instant lastSeen= Instant.now();
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name="user_authority",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "name")}
    )
    private Set<AuthorityEntity> authorities=new HashSet<>();
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name="user_conversation",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "conversation_id",referencedColumnName = "id")}
    )
    private Set<ConversationEntity> conversations=new HashSet<>();

    public UserEntity(Long id, String firstname, String lastname, UUID publicId, String imageUrl, String email, Instant lastSeen, Set<AuthorityEntity> authorrities, Set<ConversationEntity> conversations) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.publicId = publicId;
        this.imageUrl = imageUrl;
        this.email = email;
        this.lastSeen = lastSeen;
        this.authorities = authorrities;
        this.conversations = conversations;
    }
    public void updateFromUser(User user){
        this.email=user.getEmail().value();
        this.lastname=user.getLastname().value();
        this.firstname=user.getFirstname().value();
        this.imageUrl=user.getImageUrl().value();
    }
    public static UserEntity from(User user){
        com.jumpy.tech.whatsappclone.infrastructure.secondary.entity.UserEntityBuilder userEntityBuilder= com.jumpy.tech.whatsappclone.infrastructure.secondary.entity.UserEntityBuilder.userEntity();
        if(user.getImageUrl()!=null){
            userEntityBuilder.imageUrl(user.getImageUrl().value());

        }
        if(user.getUserPublicId()!=null){
            userEntityBuilder.publicId(user.getUserPublicId().value());
        }
        return userEntityBuilder
                .authorities(AuthorityEntity.from(user.getAuthorities()))
                .email(user.getEmail().value())
                .firstname(user.getFirstname().value())
                .lastname(user.getLastname().value())
                .id(user.getDbId())
                .lastSeen(user.getLastSeen())
                .build();
    }
    public static User toDomain(UserEntity userEntity) {
        UserBuilder userBuilder = UserBuilder.user();

        if (userEntity.getImageUrl() != null) {
            userBuilder.imageUrl(new UserImageUrl(userEntity.getImageUrl()));
        }

        return userBuilder
                .email(new UserEmail(userEntity.getEmail()))
                .lastname(new UserLastname(userEntity.getLastname()))
                .firstname(new UserFirstname(userEntity.getFirstname()))
                .authorities(AuthorityEntity.toDomain(userEntity.getAuthorrities()))
                .userPublicId(new UserPublicId(userEntity.getPublicId()))
                .lastModifiedDate(userEntity.getLastModifiedDate())
                .createdDate(userEntity.getCreatedDate())
                .dbId(userEntity.getId())
                .lastSeen(userEntity.getLastSeen())
                .build();
    }
    public static Set<UserEntity> from(List<User> users){
        return users.stream().map(UserEntity::from).collect(Collectors.toSet());
    }
    public static Set<User> toDomain(Set<UserEntity> user){
        return user.stream().map(UserEntity::toDomain).collect(Collectors.toSet());
    }


    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public Set<AuthorityEntity> getAuthorrities() {
        return authorities;
    }

    public Set<ConversationEntity> getConversations() {
        return conversations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setAuthorrities(Set<AuthorityEntity> authorrities) {
        this.authorities = authorrities;
    }

    public void setConversations(Set<ConversationEntity> conversations) {
        this.conversations = conversations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(publicId, that.publicId) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(email, that.email) && Objects.equals(lastSeen, that.lastSeen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, publicId, imageUrl, email, lastSeen);
    }
}
