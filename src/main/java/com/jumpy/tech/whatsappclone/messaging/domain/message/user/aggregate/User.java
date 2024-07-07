package com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.*;
import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

import java.time.Instant;
import java.util.Set;

@Builder
public class User {
 private UserLastname lastname;
 private UserFirstname firstname;
 private UserEmail email;
 private UserPublicId userPublicId;
 private UserImageUrl imageUrl;
 private Instant lastModifiedDate;
 private Instant createdDate;
 private Instant lastSeen;
 private Set<Authority> authorities;
 private Long dbId;

    public User(UserLastname lastname, UserFirstname firstname, UserEmail email,
                UserPublicId userPublicId, UserImageUrl imageUrl,
                Instant lastModifiedDate, Instant createdDate, Instant lastSeen,
                Set<Authority> authorities, Long dbId) {
        assertMandatoryFields(lastname,firstname,email,authorities);
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.userPublicId = userPublicId;
        this.imageUrl = imageUrl;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastSeen = lastSeen;
        this.authorities = authorities;
        this.dbId = dbId;
    }
    private void assertMandatoryFields(UserLastname lastname, UserFirstname firstname, UserEmail email,Set<Authority> authorities){
        Assert.notNull("lastname",lastname);
        Assert.notNull("firstname",firstname);
        Assert.notNull("email",email);
        Assert.notNull("authorities",authorities);
    }
    private void updateFromUser(User user){
        this.email=user.email;
        this.lastname=user.lastname;
        this.firstname=user.firstname;
        this.imageUrl=user.imageUrl;
    }
    public void initFieldForSignup(){
        this.lastSeen=Instant.now();
    }

    public UserLastname getLastname() {
        return lastname;
    }

    public UserFirstname getFirstname() {
        return firstname;
    }

    public UserEmail getEmail() {
        return email;
    }

    public UserPublicId getUserPublicId() {
        return userPublicId;
    }

    public UserImageUrl getImageUrl() {
        return imageUrl;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Long getDbId() {
        return dbId;
    }
}

