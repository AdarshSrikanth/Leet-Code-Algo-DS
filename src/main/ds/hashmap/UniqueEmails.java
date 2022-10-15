package main.ds.hashmap;

import java.util.HashMap;
import java.util.Scanner;

import main.Util;

public class UniqueEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Util.println("Unique Emails: " + numUniqueEmails(emails));
        sc.close();
    }

    public static int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for (int i = 0; i < emails.length; i++) {
            String[] mail = emails[i].split("@");
            mail[0] = mail[0].split("\\+")[0];
            mail[0] = mail[0].replace(".", "");            
            String email = mail[0] + "@" + mail[1];
            countMap.put(email, countMap.getOrDefault(email, 0) + 1);
        }
        return countMap.size();
    }
}
