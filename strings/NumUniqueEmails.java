
class NumUniqueEmails {
    public int find(String[] emails) {
        Set<String> found = new HashSet();
        for (String email : emails) { 
            String[] split = email.split("@");
            String address = split[0];
            if (address.contains("+")) address = address.substring(0, address.indexOf("+"));
            address = address.replaceAll(".", "");
            found.add(address + "@" + split[1]);
        }
        return found.size();
    }
}