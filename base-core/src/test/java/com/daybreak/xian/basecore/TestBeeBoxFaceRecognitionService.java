//package com.daybreak.basecore;
//
//import com.alibaba.fastjson.JSONObject;
//import com.daybreak.xian.face_adapter.FaceRecognitionManager;
//import com.daybreak.xian.face_adapter.core.bean.ReturnResult;
//import com.daybreak.xian.face_adapter.core.service.FaceRecognitionService;
//import com.daybreak.xian.face_adapter.core.service_impl_platform.beebox.BeeBoxUtils;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: maxiaoqian
// * @Date: 2019/4/13 0013 15:22
// * @Version 1.0
// */
//@RunWith(SpringRunner.class)
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
//@SpringBootTest(classes = { BaseCoreApplication.class })
//@Slf4j
//@Data
//public class TestBeeBoxFaceRecognitionService {
//
//    //新增多个人同时添加一个时间规则，下发到指定的多台设备中去！
//    @Test
//    public void testAddPersonsAndDispatchPassRulesToDevices(){
//        //先初始化saas2.0中间件，后面即可正常使用
//        FaceRecognitionManager.initialBeeBoxConfig("http://192.168.1.22", "80", 1,
//                "rqqdlOLc", "c48227ac2c5c07270fb264df0e749b07", "D:/saasPicTemp/");
//        FaceRecognitionService<JSONObject, JSONObject, JSONObject> faceRecognitionService =
//                FaceRecognitionManager.getFaceRecognitionManager().getFaceRecognitionService();
//
//        //1.第1个*************************************************************
//        JSONObject person1 = new JSONObject();
//        person1.put("elementType", "PERSONNEL");
//        person1.put("personSn", "PERS_00001");
//        person1.put("personName", "老马1");
//        person1.put("personSex", "男");
//        person1.put("personIdNumber", "612301199101011234");
//
//        //准备人员的照片
//        String picBase641 = BeeBoxUtils.jpgToBase64("D:/ma.jpg");
//        //生成jpg图片数据，测试插入图片功能
//        JSONObject jsonPic1 = new JSONObject();
//        jsonPic1.put("elementType", "PICTURE");
//        jsonPic1.put("picName", "ma.jpg");
//        jsonPic1.put("picBase64", picBase641);
//
//        //将转换好的照片json信息放入人员中
//        person1.put("personPic", jsonPic1);
//
//        //2.第2个*************************************************************
//        JSONObject person2 = new JSONObject();
//        person2.put("elementType", "PERSONNEL");
//        person2.put("personSn", "PERS_00002");
//        person2.put("personName", "老马2");
//        person2.put("personSex", "男");
//        person2.put("personIdNumber", "612301199101011234");
//
//        //3.第3个*************************************************************
//        JSONObject person3 = new JSONObject();
//        person3.put("elementType", "PERSONNEL");
//        person3.put("personSn", "PERS_00003");
//        person3.put("personName", "老马3");
//        person3.put("personSex", "男");
//        person3.put("personIdNumber", "612301199101011234");
//
//        //准备人员的照片
//        String picBase643 = BeeBoxUtils.jpgToBase64("D:/20001.jpg");
//        //生成jpg图片数据，测试插入图片功能
//        JSONObject jsonPic3 = new JSONObject();
//        jsonPic3.put("elementType", "PICTURE");
//        jsonPic3.put("picName", "20001.jpg");
//        jsonPic3.put("picBase64", picBase643);
//
//        //将转换好的照片json信息放入人员中
//        person3.put("personPic", jsonPic3);
//
//        //4.第4个ID重复*************************************************************
//        JSONObject person4 = new JSONObject();
//        person4.put("elementType", "PERSONNEL");
//        person4.put("personSn", "PERS_00004");
//        person4.put("personName", "老马4");
//        person4.put("personSex", "男");
//        person4.put("personIdNumber", "612301199101011234");
//
//        //5.第5个必填项未填*************************************************************
//        JSONObject person5 = new JSONObject();
//        person5.put("elementType", "PERSONNEL");
//        person5.put("personSn", "PERS_00005");
//        person5.put("personName", "老马5");
//        person5.put("personSex", "男");
//        person5.put("personIdNumber", "612301199101011234");
//
//        //将5个人员json对象封装至List集合中
//        List<JSONObject> persons = new ArrayList<>();
//        persons.add(person1);
//        persons.add(person2);
//        persons.add(person3);
//        persons.add(person4);
//        persons.add(person5);
//
//        List<String> deviceSns = new ArrayList<>();
//        deviceSns.add("FC242218490046");
//        deviceSns.add("H2013319020031");
//        deviceSns.add("FC241118370043");
//        deviceSns.add("FC242218490082");
//
//        ReturnResult<JSONObject> ret = faceRecognitionService.addPersonsAndDispatchPassRulesToDevices(persons, deviceSns, null);
//
//        log.info("开通结果如下：" + ret.toString());
//    }
//
//    @Test
//    @Ignore
//    public void testDispatchPersonsPassRulesToDevices()
//    {
//        FaceRecognitionService<JSONObject, JSONObject, JSONObject> faceRecognitionService =
//                FaceRecognitionManager.getFaceRecognitionManager().getFaceRecognitionService();
//
//        List<String> personSns = new ArrayList<>();
//        personSns.add("tiancao222");
//        personSns.add("PERS_00002");
//        personSns.add("123456");
//
//        List<String> deviceSns = new ArrayList<>();
//        deviceSns.add("FC242218490046");
//        deviceSns.add("H2013319020031");
//        deviceSns.add("FC241118370043");
//        deviceSns.add("123456789");
//
//        ReturnResult<JSONObject> ret = faceRecognitionService.dispatchPersonsPassRulesToDevices(personSns, deviceSns, null);
//
//        log.info("开通结果如下：" + ret.toString());
//    }
//}
