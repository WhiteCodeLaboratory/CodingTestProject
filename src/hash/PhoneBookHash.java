package hash;

import java.util.Arrays;
import java.util.List;

public class PhoneBookHash {

  public static void main(String[] args) {
    System.out.println(new PhoneBookHash().solution(new String[]{"119", "97674223", "1195524421"}));
    System.out.println(new PhoneBookHash().solution(new String[]{"123", "456", "789"}));
    System.out.println(new PhoneBookHash().solution(new String[]{"12", "123", "1235", "567", "88"}));
  }

  public boolean solution(String[] phone_book) {
    if (phone_book.length == 0 && phone_book.length > 1000000) {
      throw new RuntimeException("### failed ###");
    }
    boolean answer = true;
    List<String> phoneBookList = Arrays.asList(phone_book);
    for (String phoneBook : phone_book) {
      if (phoneBook.length() > 20) throw new RuntimeException("### failed ###");
      for (String phoneBookTemp : phoneBookList) {
        if (phoneBook.equals(phoneBookTemp)) continue;
        if (phoneBookTemp.length() > phoneBook.length()) {
          if (phoneBookTemp.startsWith(phoneBook)) {
            answer = false;
            break;
          }
        } else {
          if (phoneBook.startsWith(phoneBookTemp)) {
            answer = false;
            break;
          }
        }
      }
    }
    return answer;
  }

}
