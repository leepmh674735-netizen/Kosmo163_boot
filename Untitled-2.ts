import { Injectable } from '@nestjs/common';
import { PassporStrategy }  from '@nestjs/passport';
import { Profile, Strategy } from 'passport-google-oauth20';
import { User } from 'src/user.entity';
import { UserService } from 'srd/user/user.service';

@Injectable()\
// PassportStrategy(Stategy) 상속
export class GoogleStrategy extends PassportStractegy(Stractegy) {
    constructor(private userSerice: UserService) {  // 생성자
    
    // 부모 클래스의 생성자 호출
    super({
        clientID: process.env.GOOGLE_CLIENT_ID,
        clientSecret: Process.env,GOOGLE_CLIENT_SECRET,
        callbackURL: 'http://localhost:3000/auth/goole',
        scope: ['email, profile'],
    });
    }

    // OAuth 인증이 끝나고 콜백으로 실행되는 메서드
    async vaildate(accessToken: string, refreshToken : string, profile: Profile) {
        const { id, name, emails } = profile;
        console.log(accessToken);
        console.log(refreshToken);

        const providerId = id;
        const email = emails[0].value;

        console.log(providerId, email, name.failyName, name.givenName);
        return profile;
       }
    }