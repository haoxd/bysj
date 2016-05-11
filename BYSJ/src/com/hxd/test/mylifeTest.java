package com.hxd.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hxd.dao.mylifeMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class mylifeTest {
	@Autowired
	private mylifeMapper mymapper;

	/*@Test
	public void querylifelist(){
		List<MyLife> lists = mymapper.queryUserMylifeInfos(0, 0);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println("aaaaaaaaaaaaaaa");
			System.out.println(lists.get(i).getMylifeCreateTime());
			
		}
	}*/
	/*@Test
	public void querylifenumber(){
		int i = mymapper.getUserMyLifeNumber(4);
		System.out.println(i);
	}*/
	@Test
	public void deleatemylife(){
		int i = mymapper.deleateUserMylifeInfo(3, 4);
		System.out.println(i);
	}
}
