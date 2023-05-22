package com.example.querydsl.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class BaseUtil {
    public static long createRandomNumber(int begin, int end) {
        return (long) (Math.random() * end) + begin;
    }

    /**
     * Random 문자 생성 (https://taetae0079.tistory.com/22)
     */
    public static String createRandomString(int length) {
        return RandomStringUtils.random(length);
    }

    public static String createRamonString(String str, int length) {
        return str + RandomStringUtils.random(length);
    }

    public static String createRandomName() {
        try {
            List<String> first = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "피",
                    "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
                    "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
                    "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금", "재",
                    "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
            List<String> names = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "왕",
                    "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
                    "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
                    "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
                    "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
                    "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
                    "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
                    "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "결",
                    "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
                    "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
            Collections.shuffle(first);
            Collections.shuffle(names);
            return first.get(0) + names.get(0) + names.get(1);
        } catch (Exception e) {
            log.error(e.getMessage() + "," + e);
            return createRandomString(5);
        }
    }

    public static String createRandomId() {
        return nId() + nNo2();
    }

    public static String createRandomPhoneNumber() {
        return nPhone() + "-" + nNo() + "-" + nNo();
    }

    public static String createRandomBirthDate() {
        try {
            List<String> 도 = Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18");
            List<String> 년도 = Arrays.asList("19", "20");
            List<String> 월 = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
            List<String> 일 = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");

            Collections.shuffle(년도);
            Collections.shuffle(월);
            Collections.shuffle(일);
            String text = 년도.get(0);
            if (text.equals("19")) {
                text += ((int) (Math.random() * 69) + 30) + "";
            } else if (text.equals("20")) {
                Collections.shuffle(도);
                text += 도.get(0);
            }
            return text + "/" + 월.get(0) + "/" + 일.get(0);
        } catch (Exception e) {
            log.error(e.getMessage() + e);
            return createRandomString(4) + "/" + createRandomString(2) + "/" + createRandomString(2);
        }
    }

    public static String createRandomNickName() {
        try {
            List<String> 닉 = Arrays.asList("기분나쁜", "기분좋은", "신바람나는", "상쾌한", "짜릿한", "그리운", "자유로운", "서운한", "울적한", "비참한", "위축되는", "긴장되는", "두려운", "당당한", "배부른", "수줍은", "창피한", "멋있는",
                    "열받은", "심심한", "잘생긴", "이쁜", "시끄러운");
            List<String> 네임 = Arrays.asList("사자", "코끼리", "호랑이", "곰", "여우", "늑대", "너구리", "침팬치", "고릴라", "참새", "고슴도치", "강아지", "고양이", "거북이", "토끼", "앵무새", "하이에나", "돼지", "하마", "원숭이", "물소", "얼룩말", "치타",
                    "악어", "기린", "수달", "염소", "다람쥐", "판다");
            Collections.shuffle(닉);
            Collections.shuffle(네임);
            String text = 닉.get(0) + 네임.get(0);
            return text;
        } catch (Exception e) {
            log.error(e.getMessage() + e);
            return createRandomString(10);
        }
    }

    public static String createRandomAddress() {
        try {
            List<String> 행정구역 = Arrays.asList("서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시",
                    "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도",
                    "경상북도", "포항시", "경상남도", "진주시", "제주특별자치도"
            );

            List<String> 시 = Arrays.asList("수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "동두천시", "평택시", "안산시", "고양시", "과천시",
                    "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시",
                    "양주시", "포천시", "여주시", "춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "청주시", "충주시", "제천시", "천안시",
                    "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "전주시", "군산시", "익산시", "정읍시", "남원시", "김제시", "목포시",
                    "여수시", "순천시", "나주시", "광양시", "포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "창원시",
                    "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시");

            List<String> 자치구 = Arrays.asList(
                    // 서울
                    "종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구"
                    , "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구",
                    "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구",
                    // 부산
                    "중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "강서구", "해운대구", "사하구", "금정구", "연제구", "수영구", "사상구",
                    // 대구
                    "중구", "동구", "서구", "남구", "북구", "수성구", "달서구",
                    // 인천
                    "중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구",
                    // 광주
                    "동구", "서구", "남구", "북구", "광산구",
                    // 대전 광역시
                    "동구", "중구", "서구", "유성구", "대덕구",
                    // 울산
                    "중구", "남구", "동구", "북구",
                    // 경기도
                    "장안구", "권선구", "팔달구", "영통구", "수정구", "중원구", "분당구", "만안구", "동안구", "상록구", "단원구", "덕양구",
                    "일산동구", "일산서구", "처인구", "기흥구", "수지구", "상당구", "흥덕구", "서원구", "청원구", "동남구", "서북구", "완산구",
                    "덕진구", "남구", "북구", "의창구", "성산구", "마산합포구", "마산회원구", "진해구"
            );

            List<String> 군 = Arrays.asList(
                    "기장군", "달성군", "군위군", "강화군", "옹진군", "울주군", "연천군", "가평군", "양평군", "홍천군", "횡성군", "영월군",
                    "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군", "보은군", "옥천군", "영동군", "증평군",
                    "진천군", "괴산군", "음성군", "단양군", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군",
                    "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군",
                    "신안군", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군", "의령군", "함안군",
                    "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"
            );
            Collections.shuffle(행정구역);
            Collections.shuffle(자치구);
            Collections.shuffle(시);
            Collections.shuffle(군);
            String text = 행정구역.get(0) + " " + 자치구 + " " + 시 + " " + 군.get(0);
            return text;
        } catch (Exception e) {
            log.error(e.getMessage() + e);
            return createRandomString(25);
        }
    }

    private static String nPhone() {
        try {
            List<String> phoneNumber = Arrays.asList("02", "031", "032", "033", "041", "043", "042"
                    , "044", "051", "052", "053", "054", "055", "061", "062"
                    , "063", "064", "070", "010", "011", "012", "013", "016", "017", "019");
            Collections.shuffle(phoneNumber);
            return phoneNumber.get(0);
        } catch (Exception e) {
            log.error(e.getMessage() + e);
            return createRandomString(3) + "-" + createRandomString(4) + "-" + createRandomString(4);
        }
    }

    private static int nNo() {
        return (int) (Math.random() * 8999) + 1000;
    }

    private static String nId() {
        String text = "";
        String ran = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 6; i++) {
            text += ran.charAt((int) (Math.random() * ran.length()));
        }
        return text;
    }

    private static String nNo2() {
        return (int) (Math.random() * 99) + 1 + "";
    }
}
