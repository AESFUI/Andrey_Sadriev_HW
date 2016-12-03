package inno.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@SequenceGenerator(name = "commentSeq", sequenceName = "comment_seq")
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSeq")
    private Long id;
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
