package cn.com.taiji.redis.test.serviceImpl;


import cn.com.taiji.redis.test.model.User;
import cn.com.taiji.redis.test.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUser(String id) {
        //  fdsjjflksjflj
        try {
            System.out.println(id + "进入实现类获取数据！");
            User user = new User();
            user.setId(id);
            user.setName("testuser");
            user.setAge(18);
            return user;
        } catch (Exception e) {

            System.out.println("fjsdkjflksjlfsd");
        }
        return null;
    }

    @Override
    public User getUserChangeAge(String id, String age) {
        System.out.println(id + "进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("testuser");
        user.setAge(Integer.valueOf(age));
        return user;
    }

    @Override
    public User getUserChangeAgeInside(String id, String age) {
        deleteUser(Integer.valueOf(id));
        System.out.println(id + "进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("testuser");
        user.setAge(Integer.valueOf(age));
        return user;
    }

    @Override
    public void deleteUser(int id) {
        System.out.println(id + "进入实现类删除数据！");
    }

    @Override
    public User putUser(String id) {//每次都会执行
        System.out.println(id + "进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("testuserput");
        user.setAge(20);
        return user;
    }

    @Override
    public User getUserNokey(String id, String age) {
        System.out.println(id + "进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("testuser");
        user.setAge(Integer.valueOf(age));
        return user;
    }


    @Cacheable(value = "users", key = "'user_'+#id")
    User a(String id, String age) {
        b("", "");
        return null;
    }

    ;


    @Cacheable(value = "users", key = "'user_'+#id")
    User b(String id, String age) {

        return null;
    }

    ;


}
