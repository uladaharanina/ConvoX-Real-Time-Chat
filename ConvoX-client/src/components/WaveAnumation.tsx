import React, { useEffect, useState } from 'react';
import anime from 'animejs';
import '../styles/WaveStyle.css';


const WaveAnimation: React.FC = () => {
    const [wavePath, setWavePath] = useState(
        'M0 108.306L50 114.323C100 120.34 200 132.374 300 168.476C400 204.578 500 264.749 600 246.698C700 228.647 800 132.374 900 108.306C1000 84.2382 1100 132.374 1150 156.442L1200 180.51V0H1150C1100 0 1000 0 900 0C800 0 700 0 600 0C500 0 400 0 300 0C200 0 100 0 50 0H0V108.306Z'
      );
      
  useEffect(() => {
    const wave1 =
      'M0 108.306L50 114.323C100 120.34 200 132.374 300 168.476C400 204.578 500 264.749 600 246.698C700 228.647 800 132.374 900 108.306C1000 84.2382 1100 132.374 1150 156.442L1200 180.51V0H1150C1100 0 1000 0 900 0C800 0 700 0 600 0C500 0 400 0 300 0C200 0 100 0 50 0H0V108.306Z';
    const wave2 =
      'M0 250L50 244.048C100 238.095 200 226.19 300 226.19C400 226.19 500 238.095 600 232.143C700 226.19 800 202.381 900 196.429C1000 190.476 1100 202.381 1150 208.333L1200 214.286V0H1150C1100 0 1000 0 900 0C800 0 700 0 600 0C500 0 400 0 300 0C200 0 100 0 50 0H0V250Z';
    const wave3 =
      'M0 250L50 238.095C100 226.19 200 202.381 300 166.667C400 130.952 500 83.3333 600 101.19C700 119.048 800 202.381 900 214.286C1000 226.19 1100 166.667 1150 136.905L1200 107.143V0H1150C1100 0 1000 0 900 0C800 0 700 0 600 0C500 0 400 0 300 0C200 0 100 0 50 0H0V250Z';
    const wave4 =
      'M0 125L50 111.111C100 97.2222 200 69.4444 300 97.2222C400 125 500 208.333 600 236.111C700 263.889 800 236.111 900 229.167C1000 222.222 1100 236.111 1150 243.056L1200 250V0H1150C1100 0 1000 0 900 0C800 0 700 0 600 0C500 0 400 0 300 0C200 0 100 0 50 0H0V125Z';

    // Anime.js animation
    anime({
      targets: '.wave-top > path',
      easing: 'linear',
      duration: 7500,
      loop: true,
      d: [
        { value: [wave1, wave2] },
        { value: wave3 },
        { value: wave4 },
        { value: wave1 },
      ],
      update: (anim) => {
        setWavePath(anim.animations[0].currentValue);
      },
    });
  }, []);

  return (
    <div className="wave-container">
      <svg className="wave-top" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 250">
        <path
          d={wavePath}
          fill="var(--primary)"
          stroke="var(--primary)"
          strokeWidth="2"
        ></path>
      </svg>
    </div>
  );
};

export default WaveAnimation;
