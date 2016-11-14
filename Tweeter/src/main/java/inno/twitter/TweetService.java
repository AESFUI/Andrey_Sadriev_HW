package inno.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    private static int ids = 0;


    private List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getAll() {
        return tweets;
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        tweet.setComment(null);
        return tweets.add(tweet);
    }

    public void fixMessage(long id, String messageFix) {
        Tweet tweet = getById(id);
        tweet.setMessage(messageFix);
        tweet.setCreatedAt(new Date());
        tweet.setComment(null);
        tweet.setId(id);
        tweets.set((int) id, tweet);    //  Туплю, тут надо пофиксить
    }

    public boolean delete(long id) {
    Tweet tweet = getById(id);
        return tweets.remove(tweet);
}

    public String addComment(long id, String comment) {
        return getById(id).setComment(comment);
    }

    public Tweet getById(long id) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }
}
