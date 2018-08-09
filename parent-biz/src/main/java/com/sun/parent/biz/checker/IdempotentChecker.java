/**
 * 
 * 坤普 Copyright (c) 2016-2017 KunPu,Inc.All Rights Reserved.
 */
package com.sun.parent.biz.checker;

import com.sun.parent.common.exception.param.RepeatCheckException;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liukai
 * @version $Id: IdempotentChecker.java, v 0.1 2017年6月16日 上午11:26:02 liukai Exp $
 */
@Component("idempotentChecker")
public class IdempotentChecker implements Checker {

  /**
   * 检查幂等
   * @param obj
   * @param busType
   * @throws RepeatCheckException
   */
  public void checkRepeat(Object obj, String busType) throws RepeatCheckException {

  }


}
