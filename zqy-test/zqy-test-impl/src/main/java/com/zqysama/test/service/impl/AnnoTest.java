package com.zqysama.test.service.impl;

import java.lang.annotation.Documented;

/**
 * @author 周泉宇
 */
@Documented
public @interface AnnoTest {

    String a() default "";
}
