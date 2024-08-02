import JSConfetti from "js-confetti";

function Firecracker({clickName}) {
  //HTML Canvas 요소를 생성하여 페이지에 추가
  const jsConfetti = new JSConfetti(); 

  //색종이 커스터마이징
  const handleClick2 = () => {
    jsConfetti.addConfetti({
      confettiColors: [
        "#ff0a54",
        "#ff477e",
        "#ff7096",
        "#ff85a1",
        "#fbb1bd",
        "#f9bec7",
      ],
      confettiRadius: 5,
      confettiNumber: 500,
    });
  };

  return <button onClick={handleClick2} className="btn btn-primary">{clickName}</button>;
}

export default Firecracker;