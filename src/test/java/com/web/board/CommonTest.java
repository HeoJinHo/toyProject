package com.web.board;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public class CommonTest {

//
//    @Autowired
//    ItemRepository itemRepository;
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Autowired
//    JPAQueryFactory queryFactory;
//
//
//
//
//
//    @Test
//    @DisplayName("ItemSearch")
//    public void getItemList(){
//        //given
//        queryFactory
//                .selectFrom(item)
//                .fetch();
//
//        //when
//
//        //the
//
//    }
//
//
//
//    @Test
//    @DisplayName("QueryDSL TEST")
//    public void queryDslTest(){
//        //given
//        String userId = "hjh701234";
//
//        //when
//        Member member1 = queryFactory.selectFrom(member)
//                .where(
//                        member.userId.eq(userId)
//                )
//                .fetchOne();
//
//        //then
//        assertThat(member1.getUserId()) .isEqualTo(userId);
//
//    }
//
//
//    @Test
//    @DisplayName("카테고리넣기")
//    @Rollback(value = false)
//    @Transactional
//    public void saveCategory(){
//        //given
//        int cnt = 10;
//
//        //when
//        for (int i = 0; i < cnt; i++) {
//            Category category = new Category();
//            category.setId(null);
//            category.setName("카테고리"+i);
//            categoryRepository.save(category);
//
//        }
//
//        //the
//
//    }
//
//
//    @Test
//    @DisplayName("계산기 테스트")
//    public void calculatorTest(){
//        //given
//        Scanner sc = new Scanner(System.in);
//
//        //when
//        System.out.println("첫번째 숫자를 입력해주세요.");
//        int firstNumber = sc.nextInt();
//
//        System.out.println("계산할 연산자를 입력해주세요.");
//        String ttt = sc.nextLine();
//
//
//        System.out.println("두번째 숫자를 입력해주세요.");
//        int secondNumber = sc.nextInt();
//
//        //then
//
//        int finalNumber = 0;
//
//        switch (ttt) {
//            case "+" : finalNumber = firstNumber + secondNumber;
//            break;
//            case "-" : finalNumber = firstNumber - secondNumber;
//                break;
//            case "/" : finalNumber = firstNumber / secondNumber;
//                break;
//            case "*" : finalNumber = firstNumber * secondNumber;
//                break;
//        }
//
//        System.out.println("계산 결과입니다.");
//        System.out.println("finalNumber = " + finalNumber);
//
//    }
//
//
//
//
//
//
//    @Test
//    @DisplayName("이모지 길이 테스트")
//    public void emojiTest() throws UnsupportedEncodingException {
//        //given
//        int length = "👩‍🚀".length();
//        int length2 = "😀".length();
//        int length3 = "👩‍👩‍👦‍👦".length();
//
//        //when
//        System.out.println("length = " + length);
//        System.out.println("length2 = " + length2);
//        System.out.println("length3 = " + length3);
//        //the
//
//    }
//
//
//
//
//
//
//
//
//











}