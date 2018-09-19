package yaser.com.ostad.Messenger.data.fixtures;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.UUID;

import yaser.com.ostad.R;

/*
 * Created by Anton Bevza on 1/13/17.
 */
abstract class FixturesData {

    static final ArrayList<Integer> groupChatImages = new ArrayList<Integer>() {
        {
            add((R.drawable.person));
            add((R.drawable.person));
            add((R.drawable.person));
        }
    };
    static final ArrayList<String> groupChatTitles = new ArrayList<String>() {
        {
            add("مجید صدرایی");
            add("یاسر محمدی");
            add("حسین اکبری");
        }
    };
    static final ArrayList<String> names = new ArrayList<String>() {
        {
            add("حسین اکبری");
            add("یاسر محمدی");
            add("مجید صدرایی");
            add("سید سعید ذاکر");
            add("محمد موسوی");
        }
    };
    static final ArrayList<String> messages = new ArrayList<String>() {
        {
            add("سلام!");
        }
    };
    static final ArrayList<Integer> images = new ArrayList<Integer>() {
        {
            add((R.drawable.person));
            add((R.drawable.person));
            add((R.drawable.person));
        }
    };
    static SecureRandom rnd = new SecureRandom();
    static ArrayList<Integer> avatars = new ArrayList<Integer>() {
        {
            add(R.drawable.person);
            add((R.drawable.person));
            add((R.drawable.person));
            add((R.drawable.person));
        }
    };

    static String getRandomId() {
        return Long.toString(UUID.randomUUID().getLeastSignificantBits());
    }

    static Integer getRandomAvatar() {
        return avatars.get(rnd.nextInt(avatars.size()));
    }

    static Integer getRandomGroupChatImage() {
        return groupChatImages.get(rnd.nextInt(groupChatImages.size()));
    }

    static String getRandomGroupChatTitle() {
        return groupChatTitles.get(rnd.nextInt(groupChatTitles.size()));
    }

    static String getRandomName() {
        return names.get(rnd.nextInt(names.size()));
    }

    static String getRandomMessage() {
        return messages.get(rnd.nextInt(messages.size()));
    }

    static Integer getRandomImage() {
        return images.get(rnd.nextInt(images.size()));
    }

    static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }
}
