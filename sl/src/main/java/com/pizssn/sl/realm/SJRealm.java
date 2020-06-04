package com.pizssn.sl.realm;

import com.pizssn.sl.entity.User;
import com.pizssn.sl.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/*
* Realm： 是 Shiro 和安全相关数据（比如用户信息）的桥梁，
* 也就是说，Realm 负责从数据源中获取数据并加工后传给 SecurityManager。
* */
public class SJRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        User user = userService.findByUsername(userName);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
