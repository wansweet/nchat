package com.github.ompc.nchat.util;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串操作工具类
 * @author vlinux
 *
 */
public class NChatStringUtils {

	/**
	 * 提取出远程访问者
	 * @param ctx
	 * @return
	 */
	public static String getRemoter(ChannelHandlerContext ctx) {
		final InetSocketAddress remote = (InetSocketAddress) ctx.channel().remoteAddress();
		final StringBuilder sb = new StringBuilder();
		sb.append(remote.getHostName()).append(":").append(remote.getPort());
		return sb.toString();
	}
	
	/**
	 * 提取出远程访问者
	 * @param ctx
	 * @return
	 */
	public static String getRemoter(Channel channel) {
		final InetSocketAddress remote = (InetSocketAddress) channel.remoteAddress();
		final StringBuilder sb = new StringBuilder();
		sb.append(remote.getHostName()).append(":").append(remote.getPort());
		return sb.toString();
	}
	
	/**
	 * 判断是否是命令<br/>
	 * 命令以/开头
	 * @param words
	 * @return
	 */
	public static boolean isCommand(final String words) {
		return StringUtils.startsWith(words, "/");
	}
	
	/**
	 * 判断是否是字符操作
	 * @param msg
	 * @return
	 */
	public static boolean isWords(Object msg) {
		return null != msg
				&& msg instanceof String;
	}
	
	/**
	 * 提取命令及其参数，并以数组的形式返回
	 * @param words
	 * @return
	 */
	public static String[] getCmdOp(String words) {
		if( StringUtils.isBlank(words) ) {
			return null;
		}
		return StringUtils.split(words);
	}
	
	/**
	 * 只要strs中有任何一个包含了str，返回true，否则返回false
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean equalsIgnoreCaseIn(String str, String... strs) {
		if( null == strs ) {
			return false;
		}
		for( String s : strs ) {
			if( StringUtils.equalsIgnoreCase(str, s) ) {
				return true;
			}
		}
		return false;
	}
	
}
