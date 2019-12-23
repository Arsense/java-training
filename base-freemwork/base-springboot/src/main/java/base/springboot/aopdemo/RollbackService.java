package base.springboot.aopdemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Clay
 * @date 2019/7/8 20:05
 */
@Service
public class RollbackService {

    @Transactional
    public int saveList() {
        return  1;
    }
}

