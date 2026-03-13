package dev.rayh.cardstore.domain.account;

import dev.rayh.cardstore.exception.CPForCNPJInvalidException;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;


enum ClienType{
    FISICO,
    JURIDICO
}


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    private final String REGEX_TO_REMOVE_CPF_ESPECIAL_CHARACTERS = "[^\\p{L}\\p{N}]";

    private String cpfOrCnpj;
    private String fantasyName;
    private String socialReason;
    @Email(message = "Email invalido")
    private String email;
    private String phone;
    private ClienType type;


    public boolean normalize(){
        //remove all especial character to id;
        this.cpfOrCnpj = this.cpfOrCnpj.replaceAll(REGEX_TO_REMOVE_CPF_ESPECIAL_CHARACTERS, "");
        System.out.println(this.cpfOrCnpj);
        return checkAndUpdateType();

    }

    private boolean checkAndUpdateType(){
        if (this.cpfOrCnpj.length() == 11) {
            this.type = ClienType.FISICO;
            return this.isCpfValid();
        }else if (this.cpfOrCnpj.length() == 14) {
            this.type = ClienType.JURIDICO;
            return this.isCnpjValid();
        }else {
            throw new CPForCNPJInvalidException(
                    "the length of the id is not compatible", this);
        }
    }


    public boolean isCpfValid() {

        int firstDigit, secondDigit;
        int [] numbers;

        if (this.cpfOrCnpj.length() != 11) {
            return false;
        }        

        //colocando em vetor de inteiros
        numbers = this.cpfOrCnpj.chars().map(Character::getNumericValue).toArray();

        //verifying the first digit
        int sum = 0;
        for ( int i = 0; i < 9; i++) {
            sum += numbers[i] * (10 - i);
        }
        firstDigit = (sum * 10) % 11;
        //verifying the second digit

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numbers[i] * (11 - i);
        }
        secondDigit = (sum * 10) % 11;        
        
        return firstDigit == numbers[9] && secondDigit == numbers[10];
    }

    public boolean isCnpjValid(){
        int firstVerDigit, secondVerDigit;
        int sum = 0;
        int [] numbers = this.cpfOrCnpj.chars().map(Character::getNumericValue).toArray();

        if (numbers.length != 14)
            return false;

        //calculating the first verifier digit

        //mask to first digit
        final int[] firstMask = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < 13; i++) {
            sum += (numbers[i] * firstMask[i]);
        }
        if ((sum % 11) < 2){
            firstVerDigit = 0;
        }else {
            firstVerDigit = 11 - (sum % 2);
        }

        //verifying the second digit
        final int [] secondMask = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 14; i++) {
            sum += (numbers[i]*secondMask[i]);
        }

        if ((sum % 11) < 2){
            secondVerDigit = 0;
        }else {
            secondVerDigit = 11 - (sum % 11);
        }



        return firstVerDigit == numbers[12] && secondVerDigit == numbers[13];
    }

}

