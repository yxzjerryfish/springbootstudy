package fish.study.geekband1.model;

import lombok.Data;

import java.util.List;

/**
 * User.
 *
 * @date: 2019-12-26
 * @version: 1.0
 * @author: fish paradise
 */
@Data
public class User {
    private int id;
    private String name;
    private List userLst;
}